package com.devsoft.rps;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Game {

    Player player1;
    Player player2;

    /**
     * Determines the winner of the game based on the moves of both players.
     *
     * @return The player who has won, or null if it's a draw.
     */
    public Player playAndReturnWinner() {
        PlayMove movePlayer1 = player1.getMove();
        PlayMove movePlayer2 = player2.getMove();
        Player winner = null;
        if (!movePlayer1.equals(movePlayer2)) {
            switch (movePlayer1) {
                case ROCK -> winner = (movePlayer2.equals(PlayMove.SCISSOR)) ? player1 : player2;
                case PAPER -> winner = (movePlayer2.equals(PlayMove.ROCK)) ? player1 : player2;
                case SCISSOR -> winner = (movePlayer2.equals(PlayMove.PAPER)) ? player1 : player2;
            }
        }
        return winner;
    }

    public enum Result {
        WIN, LOSE, DRAW
    }
}
