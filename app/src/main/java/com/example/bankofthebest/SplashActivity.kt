package com.example.bankofthebest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.login.LoginActivity

class SplashActivity: AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))

            finish()
        }, SPLASH_TIME_OUT)
    }
}