package com.anandmali.lifecyclestate

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.anandmali.lifecyclestate.databinding.ActivityMainBinding
import logcat.logcat

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val logTag = SecondActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        logcat { "onCreate()" }

        binding.bindViews()
    }

    private fun ActivityMainBinding.bindViews() {
        txtActivity.text = logTag

        launchActivity.setOnClickListener {
            startActivity(Intent(this@SecondActivity, MainActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        logcat { "onStart()" }
    }

    override fun onRestart() {
        super.onRestart()
        logcat { "onRestart()" }
    }

    override fun onResume() {
        super.onResume()
        logcat { "onResume()" }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        logcat { "onSaveInstanceState()" }
    }

    override fun onPause() {
        super.onPause()
        logcat { "onPause()" }
    }

    override fun onStop() {
        super.onStop()
        logcat { "onStop()" }
    }

    override fun onDestroy() {
        super.onDestroy()
        logcat { "onDestroy()" }
    }

}