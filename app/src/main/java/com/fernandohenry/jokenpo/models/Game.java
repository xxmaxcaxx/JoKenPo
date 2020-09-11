package com.fernandohenry.jokenpo.models;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

public class Game {
    private static final String TAG = Game.class.getSimpleName();
    public Player player1;
    public Player player2;
    public MutableLiveData<Player> winner = new MutableLiveData<>();

    public Game(String playerOne, String playerTwo) {
        player1 = new Player(playerOne, "x");
        player2 = new Player(playerTwo, "o");
    }

    public boolean hasGameEnded() {
       if (player1.getValue() == "Pedra" && player2.getValue() == "Tesoura") {
            winner.setValue(player1);
            return true;
        }
        if (player1.getValue() == "Pedra" && player2.getValue() == "Pedra") {
            winner.setValue(null);
            return true;
        }
        if (player1.getValue() == "Papel" && player2.getValue() == "Papel") {
            winner.setValue(null);
            return true;
        }
        if (player1.getValue() == "Tesoura" && player2.getValue() == "Tesoura") {
            winner.setValue(null);
            return true;
        }
        return false;
    }

    public void reset() {
        player1 = null;
        player2 = null;
    }
}