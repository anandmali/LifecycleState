package com.anandmali.lifecyclestate

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.anandmali.lifecyclestate.databinding.ActivityMainBinding
import com.anandmali.lifecyclestate.location.BoundLocation
import com.anandmali.lifecyclestate.location.LifeCycleObserver
import com.anandmali.lifecyclestate.location.MyLocationListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val logTag = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(logTag, "==> onCreate() ")

        Thread.sleep(5000)
        Log.i(logTag, "==> Thread.sleep(5000) ")

        binding.bindViews()

        startLocationService()
    }

    private fun ActivityMainBinding.bindViews() {
        txtActivity.text = logTag

        launchActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }

        showFragment.setOnClickListener {
            val fragment = BlankFragment.newInstance(MainActivity::class.java.simpleName)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commitNow()
        }
    }

    private fun startLocationService() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val boundLocation = BoundLocation(this, MyLocationListener())
            lifecycle.addObserver(LifeCycleObserver(boundLocation))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(logTag, "==> onStart() ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(logTag, "==> onRestart() ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(logTag, "==> onResume() ")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.i(logTag, "==> onSaveInstanceState() ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(logTag, "==> onPause() ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(logTag, "==> onStop() ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(logTag, "==> onDestroy() ")
    }

}