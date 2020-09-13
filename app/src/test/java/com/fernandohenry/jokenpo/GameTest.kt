package com.fernandohenry.jokenpo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.fernandohenry.jokenpo.models.Game
import com.fernandohenry.jokenpo.models.Player
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var game: Game
    private lateinit var player: Player
    private lateinit var anotherPlayer: Player
    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Fernando", "Henry")
        player = game.player1
        anotherPlayer = game.player2
    }
    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasPlayer1Victory() {
        player.value = "Pedra"
        anotherPlayer.value = "Tesoura"
        val hasPlayerVictory = game.hasGameEnded()
        Assert.assertTrue(hasPlayerVictory)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasPlayer2Victory() {
        player.value = "Pedra"
        anotherPlayer.value = "Papel"
        val hasPlayerVictory = game.hasGameEnded()
        Assert.assertTrue(hasPlayerVictory)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasDraw() {
        player.value = "Pedra"
        anotherPlayer.value = "Pedra"
        val hasPlayerVictory = game.hasGameEnded()
        Assert.assertTrue(hasPlayerVictory)
    }



    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasPlayer1defeat() {
        player.value = "Tesoura"
        anotherPlayer.value = "Pedra"
        val hasPlayerVictory = game.hasGameEnded()
        Assert.assertTrue(hasPlayerVictory)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasPlayer2defeat() {
        player.value = "Papel"
        anotherPlayer.value = "Pedra"
        val hasPlayerVictory = game.hasGameEnded()
        Assert.assertTrue(hasPlayerVictory)
    }
}

