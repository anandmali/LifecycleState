package com.anandmali.lifecyclestate.location

import android.location.Location
import android.location.LocationListener
import timber.log.Timber

class MyLocationListener : LocationListener {
    override fun onLocationChanged(p0: Location) {
        Timber.i("onLocationChanged => $p0")
    }
}