package com.example.testplayer.views

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.widget.Toast
import com.example.testplayer.R
import com.example.testplayer.viewModels.DigitalStationViewModel
import com.example.testplayer.viewModels.ViewModelProvider
import kotlinx.android.synthetic.main.view_digital_player.view.*


class DigitalPlayerView(context: Context) : BasePlayerView(context) {

    private var stationViewModel: DigitalStationViewModel? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.view_digital_player, this, true)
        digital_player_dislike.setOnClickListener {
            dislike()
        }
    }

    override fun initializeViewModel(fragment: Fragment) {
        stationViewModel = ViewModelProvider.of(fragment).get(DigitalStationViewModel::class.java)
    }

    override fun initializeViewModel(activity: FragmentActivity) {
        stationViewModel = ViewModelProvider.of(activity).get(DigitalStationViewModel::class.java)
    }

    private fun dislike() {
        Toast.makeText(context, "Dislike!", Toast.LENGTH_SHORT).show()
        stationViewModel?.dislike()
    }
}

