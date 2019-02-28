package com.example.testplayer.viewModels

import android.support.annotation.ColorInt

interface StationViewModel {

    fun getType(): StationType
    fun getTitle(): String
    fun getImage(): Int
}

enum class StationType {
    DIGITAL, PODCAST
}