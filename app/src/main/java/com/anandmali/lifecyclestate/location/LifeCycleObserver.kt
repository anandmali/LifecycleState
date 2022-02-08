package com.anandmali.lifecyclestate.location

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class LifeCycleObserver(private val boundLocation: BoundLocation) : DefaultLifecycleObserver {

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        boundLocation.addLocationListener()
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        boundLocation.removeLocationListener()
    }
}