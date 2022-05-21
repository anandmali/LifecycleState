package com.anandmali.lifecyclestate

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.viewbinding.BuildConfig
import timber.log.Timber

class LifecycleApplication : Application(), Application.ActivityLifecycleCallbacks {

    private val logTag = LifecycleApplication::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        Timber.i("==> onActivityCreated() activity: " + p0.localClassName)
    }

    override fun onActivityStarted(p0: Activity) {
        Timber.i("==> onActivityStarted() activity: " + p0.localClassName)
    }

    override fun onActivityResumed(p0: Activity) {
        Timber.i("==> onActivityResumed() activity: " + p0.localClassName)
    }

    override fun onActivityPaused(p0: Activity) {
        Timber.i("==> onActivityPaused() activity: " + p0.localClassName)
    }

    override fun onActivityStopped(p0: Activity) {
        Timber.i("==> onActivityStopped() activity: " + p0.localClassName)
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        Timber.i("==> onActivitySaveInstanceState() activity: " + p0.localClassName)
    }

    override fun onActivityDestroyed(p0: Activity) {
        Timber.i("==> onActivityDestroyed() activity: " + p0.localClassName)
    }

}