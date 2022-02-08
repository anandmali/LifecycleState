package com.anandmali.lifecyclestate.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.lifecycle.LifecycleObserver


class BoundLocation(
    private val context: Context,
    private val locationListener: LocationListener
) : LifecycleObserver {

    private lateinit var locationManager: LocationManager

    @SuppressLint("MissingPermission")
    fun addLocationListener() {
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            0,
            0f,
            locationListener
        )

        val lastLocation: Location =
            locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)!!

        locationListener.onLocationChanged(lastLocation)
    }

    fun removeLocationListener() {
        locationManager.removeUpdates(locationListener)
    }
}