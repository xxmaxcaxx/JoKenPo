package com.fernandohenry.jokenpo.views.game

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fernandohenry.jokenpo.models.Game
import com.fernandohenry.jokenpo.models.Player
import com.fernandohenry.jokenpo.utils.StringUtility.stringFromNumbers

class GameViewModel : ViewModel() {
    lateinit var cells: ObservableArrayMap<String, String>
    private lateinit var game: Game
    val winner: LiveData<Player>
        get() = game.winner
    fun init(player1: String, player2: String) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }
    fun onClickedCellAt(choice: Int, player: Int) {
        if (choice == 0 && player == 1) {
            game.player1.value = "Pedra"
            if (game.hasGameEnded())
                game.reset()
        } else if (choice == 0 && player == 2){
            game.player2.value = "Pedra"
            if (game.hasGameEnded())
                game.reset()
        }

        if (choice == 1 && player == 1) {
            game.player1.value = "Papel"
            if (game.hasGameEnded())
                game.reset()
        }else if (choice == 1 && player == 2){
            game.player2.value = "Papel"
            if (game.hasGameEnded())
                game.reset()
        }

        if (choice == 2 && player == 1) {
            game.player1.value = "Tesoura"
            if (game.hasGameEnded())
                game.reset()
        }else if (choice == 2 && player == 2){
            game.player2.value = "Tesoura"
            if (game.hasGameEnded())
                game.reset()
        }
    }
}