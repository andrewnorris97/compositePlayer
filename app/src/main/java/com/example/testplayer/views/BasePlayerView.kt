package com.example.testplayer.views

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.widget.FrameLayout

abstract class BasePlayerView(context: Context): FrameLayout(context) {

    abstract fun initializeViewModel(fragment: Fragment)

    abstract fun initializeViewModel(activity: FragmentActivity)

}