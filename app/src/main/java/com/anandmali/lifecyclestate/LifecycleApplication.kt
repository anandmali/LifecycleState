package com.anandmali.lifecyclestate

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class LifecycleApplication : Application(), Application.ActivityLifecycleCallbacks {

    private val logTag = LifecycleApplication::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        Log.i(logTag, "==> onActivityCreated() activity: ${p0.localClassName}")
    }

    override fun onActivityStarted(p0: Activity) {
        Log.i(logTag, "==> onActivityStarted() activity: ${p0.localClassName}")
    }

    override fun onActivityResumed(p0: Activity) {
        Log.i(logTag, "==> onActivityResumed() activity: ${p0.localClassName}")
    }

    override fun onActivityPaused(p0: Activity) {
        Log.i(logTag, "==> onActivityPaused() activity: ${p0.localClassName}")
    }

    override fun onActivityStopped(p0: Activity) {
        Log.i(logTag, "==> onActivityStopped() activity: ${p0.localClassName}")
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        Log.i(logTag, "==> onActivitySaveInstanceState() activity: ${p0.localClassName}")
    }

    override fun onActivityDestroyed(p0: Activity) {
        Log.i(logTag, "==> onActivityDestroyed() activity: ${p0.localClassName}")
    }

}