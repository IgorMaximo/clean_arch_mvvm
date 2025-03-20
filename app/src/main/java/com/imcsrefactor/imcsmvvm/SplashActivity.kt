package com.imcsrefactor.imcsmvvm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.imcs.home.presentation.feature.HomeActivity
import com.imcs.prospekt.R
import com.tool.base.utils.BaseActivity
import org.koin.core.component.KoinApiExtension

private const val SPLASH_TO_HOME_DELAY: Long = 3000

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed(
            {
                start()
                finish()
            },
            SPLASH_TO_HOME_DELAY
        )
    }

    @OptIn(KoinApiExtension::class)
    private fun start() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}
