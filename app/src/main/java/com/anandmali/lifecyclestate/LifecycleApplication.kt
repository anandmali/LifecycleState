package com.anandmali.lifecyclestate

import android.app.Activity
import android.app.Application
import android.os.Bundle
import logcat.AndroidLogcatLogger
import logcat.LogPriority
import logcat.logcat

class LifecycleApplication : Application(), Application.ActivityLifecycleCallbacks {

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.DEBUG)
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        logcat { "onActivityCreated() activity: " + p0.localClassName }
    }

    override fun onActivityStarted(p0: Activity) {
        logcat { "onActivityStarted() activity: " + p0.localClassName }
    }

    override fun onActivityResumed(p0: Activity) {
        logcat { "onActivityResumed() activity: " + p0.localClassName }
    }

    override fun onActivityPaused(p0: Activity) {
        logcat { "onActivityPaused() activity: " + p0.localClassName }
    }

    override fun onActivityStopped(p0: Activity) {
        logcat { "onActivityStopped() activity: " + p0.localClassName }
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        logcat { "onActivitySaveInstanceState() activity: " + p0.localClassName }
    }

    override fun onActivityDestroyed(p0: Activity) {
        logcat { "onActivityDestroyed() activity: " + p0.localClassName }
    }

}