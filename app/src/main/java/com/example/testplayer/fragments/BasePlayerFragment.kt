package com.example.testplayer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testplayer.R
import com.example.testplayer.viewModels.ClipStationViewModel
import com.example.testplayer.viewModels.DigitalStationViewModel
import com.example.testplayer.viewModels.StationType
import com.example.testplayer.viewModels.StationViewModel
import com.example.testplayer.views.BasePlayerView
import com.example.testplayer.views.ClipPlayerView
import com.example.testplayer.views.DigitalPlayerView
import kotlinx.android.synthetic.main.fragment_base_player.*
import java.util.*

class BasePlayerFragment : Fragment() {

    lateinit var stationViewModel: StationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO - grab this when media is fetched as well
        fetchMediaItem()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateMetadata()
        addPlayerView()
        base_player_image.setOnClickListener {
            fetchMediaItem()
            updateMetadata()
            addPlayerView()
        }
    }

    private fun updateMetadata() {
        base_player_title.text = stationViewModel.getTitle()
        base_player_image.setBackgroundColor(stationViewModel.getImage())
    }

    private fun fetchMediaItem() {
        val random = Random()
        if (random.nextBoolean()) {
            stationViewModel = ClipStationViewModel()
        } else {
            stationViewModel = DigitalStationViewModel()
        }
    }

    private fun addPlayerView() {
        val context = requireContext()
        val playerView: BasePlayerView
        when (stationViewModel.getType()) {
            StationType.DIGITAL -> playerView = DigitalPlayerView(context)
            StationType.PODCAST -> playerView = ClipPlayerView(context)
        }

        playerView.initializeViewModel(this)
        base_player_view.removeAllViews()
        base_player_view.addView(playerView)
    }
}

