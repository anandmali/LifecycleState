package com.anandmali.lifecyclestate

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.anandmali.lifecyclestate.databinding.ActivityMainBinding
import timber.log.Timber

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val logTag = SecondActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.i("==> onCreate() ")

        Thread.sleep(5000)
        Timber.i("==> Thread.sleep(5000) ")

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
        Timber.i("==> onStart() ")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("==> onRestart() ")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("==> onResume() ")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Timber.i("==> onSaveInstanceState() ")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("==> onPause() ")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("==> onStop() ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("==> onDestroy() ")
    }

}