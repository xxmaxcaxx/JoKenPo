package com.fernandohenry.jokenpo.splash

import android.content.Intent
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.fernandohenry.jokenpo.R
import com.fernandohenry.jokenpo.menu.MenuActivity

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH = 2000
    private var ivSplash: ImageView? = null
    private var tvSplash: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        tvSplash = findViewById(R.id.tvSplash) as TextView
        ivSplash = findViewById(R.id.ivSplash) as ImageView
        configuraFonte()
        carregar()
    }

    private fun playAudio() {
        val player = MediaPlayer.create(this, R.raw.jokenpo)
        player.start()
    }

    private fun configuraFonte() {
        val fonte = Typeface.createFromAsset(assets, "fonts/game_over.ttf")
        tvSplash!!.typeface = fonte
    }

    private fun carregar() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.splash)
        anim.reset()
        if (ivSplash != null) {
            ivSplash!!.clearAnimation()
            ivSplash!!.startAnimation(anim)
        }
        Handler().postDelayed({ playAudio() }, 1000)
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity,
                MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
            startActivity(intent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}