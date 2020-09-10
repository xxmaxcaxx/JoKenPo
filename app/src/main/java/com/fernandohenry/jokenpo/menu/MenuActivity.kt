package com.fernandohenry.jokenpo.menu

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.fernandohenry.jokenpo.views.GamePlayerBotActivity
import com.fernandohenry.jokenpo.R

class MenuActivity : AppCompatActivity() {
    private var tvHeader: TextView? = null
    private var tvFooter: TextView? = null
    private var btPlay: Button? = null
    private var btRegras: Button? = null
    private var btSair: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        btPlay = findViewById(R.id.btPlay) as Button
        btSair = findViewById(R.id.btSair) as Button
        btRegras = findViewById(R.id.btRegras) as Button
        tvHeader = findViewById(R.id.tvHeader) as TextView
        tvFooter = findViewById(R.id.tvFooter) as TextView
        configuraFonte()
    }

    private fun configuraFonte() {
        val fonte = Typeface.createFromAsset(assets, "fonts/game_over.ttf")
        btPlay!!.typeface = fonte
        btSair!!.typeface = fonte
        btRegras!!.typeface = fonte
        tvHeader!!.typeface = fonte
        tvFooter!!.typeface = fonte
        tvHeader!!.textSize = 130f
        tvFooter!!.textSize = 35f
        btPlay!!.textSize = 45f
        btSair!!.textSize = 45f
        btRegras!!.textSize = 45f
    }

    fun play(v: View?) {
        startActivity(Intent(this, GamePlayerBotActivity::class.java))
    }

    fun sair(v: View?) {
        finish()
    }
}