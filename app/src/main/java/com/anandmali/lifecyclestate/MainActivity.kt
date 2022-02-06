package com.anandmali.lifecyclestate

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.anandmali.lifecyclestate.databinding.ActivityMainBinding

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

        binding.txtActivity.text = logTag

        binding.launchActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.showFragment.setOnClickListener {
            val fragment = BlankFragment.newInstance(MainActivity::class.java.simpleName)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commitNow()
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