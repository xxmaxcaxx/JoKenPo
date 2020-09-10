package com.fernandohenry.jokenpo.views

import android.media.MediaPlayer
import android.media.MediaPlayer.create
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.fernandohenry.jokenpo.R
import java.util.*


class GamePlayerBotActivity : AppCompatActivity() {

    private var numeroAleatorio: Random? = null
    private val PEDRA = 1
    private val PAPEL = 2
    private val TESOURA = 3
    private var btPedra: Button? = null
    private var btPapel: Button? = null
    private var btTesoura: Button? = null
    private var ivJogadaPlayer: ImageView? = null
    private var ivJogadaPC: ImageView? = null
    private var tvResultado: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplayerbot)

        numeroAleatorio = Random()
        ivJogadaPlayer =
            findViewById<View>(R.id.ivJogadaPlayer) as ImageView
        ivJogadaPC = findViewById<View>(R.id.ivJogadaPC) as ImageView
        tvResultado = findViewById<View>(R.id.tvResultado) as TextView
        btPedra = findViewById<View>(R.id.btPedra) as Button
        btPedra!!.setOnClickListener {
            ivJogadaPlayer!!.setImageDrawable(
                ContextCompat.getDrawable(
                    this@GamePlayerBotActivity,
                    R.drawable.pedra
                )
            )
            realizaJogada(PEDRA)
        }
        btPapel = findViewById<View>(R.id.btPapel) as Button
        btPapel!!.setOnClickListener {
            ivJogadaPlayer!!.setImageDrawable(
                ContextCompat.getDrawable(
                    this@GamePlayerBotActivity,
                    R.drawable.papel
                )
            )
            realizaJogada(PAPEL)
        }
        btTesoura = findViewById<View>(R.id.btTesoura) as Button
        btTesoura!!.setOnClickListener {
            ivJogadaPlayer!!.setImageDrawable(
                ContextCompat.getDrawable(
                    this@GamePlayerBotActivity,
                    R.drawable.tesoura
                )
            )
            realizaJogada(TESOURA)
        }
    }
    private fun realizaJogada(jogadaPlayer: Int) {
        val player: MediaPlayer = create(this, R.raw.jokenpo)
        player.start()
        val jogadaPC = numeroAleatorio!!.nextInt(3) + 1
        when (jogadaPC) {
            PEDRA -> {
                ivJogadaPC!!.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.pedra
                    )
                )
                when (jogadaPlayer) {
                    PAPEL -> venceu()
                    PEDRA -> empatou()
                    TESOURA -> perdeu()
                }
            }
            PAPEL -> {
                ivJogadaPC!!.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.papel
                    )
                )
                when (jogadaPlayer) {
                    PAPEL -> empatou()
                    PEDRA -> perdeu()
                    TESOURA -> venceu()
                }
            }
            TESOURA -> {
                ivJogadaPC!!.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.tesoura
                    )
                )
                when (jogadaPlayer) {
                    PAPEL -> perdeu()
                    PEDRA -> venceu()
                    TESOURA -> empatou()
                }
            }
        }
    }

    private fun venceu() {
        tvResultado!!.text = getString(R.string.venceu)
        tvResultado!!.setTextColor(ContextCompat.getColor(this, R.color.vitoria))
    }

    private fun perdeu() {
        tvResultado!!.text = getString(R.string.perdeu)
        tvResultado!!.setTextColor(ContextCompat.getColor(this, R.color.derrota))
    }

    private fun empatou() {
        tvResultado!!.text = getString(R.string.empatou)
        tvResultado!!.setTextColor(ContextCompat.getColor(this, R.color.empate))
    }
}