package com.example.testplayer.views

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.widget.Toast
import com.example.testplayer.R
import com.example.testplayer.viewModels.ClipStationViewModel
import com.example.testplayer.viewModels.ViewModelProvider
import kotlinx.android.synthetic.main.view_clip_player.view.*

class ClipPlayerView(context: Context) : BasePlayerView(context) {

    private var stationViewModel: ClipStationViewModel? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.view_clip_player, this, true)
        digital_player_rewind.setOnClickListener {
            rewind()
        }
    }

    override fun initializeViewModel(fragment: Fragment) {
        stationViewModel = ViewModelProvider.of(fragment).get(ClipStationViewModel::class.java)
    }

    override fun initializeViewModel(activity: FragmentActivity) {
        stationViewModel = ViewModelProvider.of(activity).get(ClipStationViewModel::class.java)
    }

    private fun rewind() {
        Toast.makeText(context, "Rewind!", Toast.LENGTH_SHORT).show()
        stationViewModel?.rewind()
    }
}