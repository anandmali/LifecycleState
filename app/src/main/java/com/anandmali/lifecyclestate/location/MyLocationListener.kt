package com.anandmali.lifecyclestate.location

import android.location.Location
import android.location.LocationListener

class MyLocationListener : LocationListener {
    override fun onLocationChanged(p0: Location) {
        println("onLocationChanged => $p0")
    }
}