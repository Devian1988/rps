package com.devsoft.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerInitialization() {
        PlayMove[] playMoves = {PlayMove.ROCK, PlayMove.PAPER};
        Player player = new Player("TestPlayer", playMoves);
        assertNotNull(player.getId());
        assertEquals("TestPlayer", player.getName());
        assertArrayEquals(playMoves, player.getAllowedMoves());
    }

    @Test
    void testGetMoveReturnsValidMove() {
        Player player = new Player("TestPlayer", PlayMove.ROCK);
        for (int i = 0; i < 100; i++) {
            PlayMove move = player.getMove();
            assertNotNull(move);
            assertSame(PlayMove.ROCK, move);
        }
    }

    @Test
    void testEqualsAndHashCode() {
        Player player1 = new Player("Player1", PlayMove.ROCK);
        Player player2 = new Player("Player2", PlayMove.PAPER);

        player2.id = player1.getId(); // Simulate same ID for equality test

        assertEquals(player1, player2);
        assertEquals(player1.hashCode(), player2.hashCode());
    }
}