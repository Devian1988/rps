package com.devsoft.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GameTest {

    @Test
    void testPlayAndReturnWinner_Player1Wins() {
        Player player1 = new Player("Player1", PlayMove.ROCK);
        Player player2 = new Player("Player2", PlayMove.SCISSOR);

        Game game = new Game(player1, player2);
        Player winner = game.playAndReturnWinner();

        assertEquals(player1, winner);
    }

    @Test
    void testPlayAndReturnWinner_Player2Wins() {
        Player player1 = new Player("Player1", PlayMove.PAPER);
        Player player2 = new Player("Player2", PlayMove.SCISSOR);

        Game game = new Game(player1, player2);
        Player winner = game.playAndReturnWinner();

        assertEquals(player2, winner);
    }

    @Test
    void testPlayAndReturnWinner_Draw() {
        Player player1 = new Player("Player1", PlayMove.ROCK);
        Player player2 = new Player("Player2", PlayMove.ROCK);

        Game game = new Game(player1, player2);
        Player winner = game.playAndReturnWinner();

        assertNull(winner);
    }
}