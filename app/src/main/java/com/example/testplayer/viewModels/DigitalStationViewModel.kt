package com.example.testplayer.viewModels

import android.graphics.Color

class DigitalStationViewModel: StationViewModel {
    override fun getTitle(): String {
        return "Digital Station"
    }

    override fun getImage(): Int {
        return Color.GREEN
    }

    override fun getType(): StationType {
        return StationType.DIGITAL
    }

    fun dislike() {

    }
}