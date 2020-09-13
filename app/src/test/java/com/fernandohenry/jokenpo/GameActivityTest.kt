package com.fernandohenry.jokenpo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.ActivityTestRule
import com.fernandohenry.jokenpo.models.Player
import com.fernandohenry.jokenpo.views.GameActivity
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import org.junit.Rule
import org.junit.Test

class GameActivityTest {
    @Rule @JvmField
    var activityRule: ActivityScenarioRule<GameActivity> = ActivityScenarioRule(GameActivity::class.java)
    private val player1 = Player("Fernando", "x")
    private val player2 = Player("Henry", "o")
    @Test
    fun end_game_when_one_player_wins() {
        writeTo(R.id.et_player1, player1.name)
        writeTo(R.id.et_player2, player2.name)
        clickDialogPositiveButton()
        clickOn(R.id.btPapelPlayer1)
        clickOn(R.id.btPedraPlayer2)
        assertDisplayed(R.id.tvWinner)
        assertDisplayed(player1.name)
    }

    @Test
    @Throws(Exception::class)
    fun display_same_names_message_if_names_same() {
        writeTo(R.id.et_player1, "Fernando")
        writeTo(R.id.et_player2, "Fernando")
        clickDialogPositiveButton()
        assertDisplayed(R.string.game_dialog_same_names)
    }

    @Test
    @Throws(Exception::class)
    fun display_empty_name_message_if_one_name_empty() {
        writeTo(R.id.et_player1, "")
        writeTo(R.id.et_player2, "Henry")
        clickDialogPositiveButton()
        assertDisplayed(R.string.game_dialog_empty_name)
    }

    @Test
    @Throws(Exception::class)
    fun close_dialog_after_names_valid() {
        writeTo(R.id.et_player1, "Fernando")
        writeTo(R.id.et_player2, "Henry")
        clickDialogPositiveButton()
        assertNotExist(R.id.player1Layout)
    }
}