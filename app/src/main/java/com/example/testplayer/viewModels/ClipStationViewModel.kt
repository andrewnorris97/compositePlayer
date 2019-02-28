package com.example.testplayer.viewModels

import android.graphics.Color

class ClipStationViewModel : StationViewModel {
    override fun getImage(): Int {
        return Color.BLUE
    }

    override fun getTitle(): String {
        return "A Podcast"
    }

    override fun getType(): StationType {
        return StationType.PODCAST
    }

    fun rewind() {

    }
}