package com.example.testplayer.viewModels

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

class ViewModelProvider {
    companion object {
        fun of(fragment: Fragment): ViewModelProvider {
            return ViewModelProvider()
        }

        fun of(activity: FragmentActivity): ViewModelProvider {
            return ViewModelProvider()
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> get(clazz: Class<*>): T? {
        // business logic to create and return instance of T
        return clazz.newInstance() as T?
    }
}