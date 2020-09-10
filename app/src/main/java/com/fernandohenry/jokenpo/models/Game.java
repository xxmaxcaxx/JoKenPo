package com.fernandohenry.jokenpo.models;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

public class Game {
    private static final String TAG = Game.class.getSimpleName();
    private static final int BOARD_SIZE = 3;
    public Player player1;
    public Player player2;
    public Player currentPlayer = player1;
    public MutableLiveData<Player> winner = new MutableLiveData<>();

    public Game(String playerOne, String playerTwo) {
        player1 = new Player(playerOne, "x");
        player2 = new Player(playerTwo, "o");
        currentPlayer = player1;
    }

    public boolean hasGameEnded() {
/*        if (hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() ||
                hasThreeSameDiagonalCells()) {
            winner.setValue(currentPlayer);
            return true;
        }
        if (isBoardFull()) {
            winner.setValue(null);
            return true;
        }*/
        return false;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
    public void reset() {
        player1 = null;
        player2 = null;
        currentPlayer = null;
    }
}
