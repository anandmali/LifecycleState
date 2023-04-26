package com.anandmali.lifecyclestate.location

import android.location.Location
import android.location.LocationListener
import logcat.logcat

class MyLocationListener : LocationListener {
    override fun onLocationChanged(p0: Location) {
        logcat { "onLocationChanged => $p0" }
    }
}