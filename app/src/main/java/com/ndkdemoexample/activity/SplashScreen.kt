@file:Suppress("DEPRECATION")

package com.ndkdemoexample.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.ndkdemoexample.R

class SplashScreen :AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            val mySuperIntent = Intent(this@SplashScreen, HomeScreen::class.java)
            mySuperIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(mySuperIntent)
            finish()
        }, 4000)
    }
}