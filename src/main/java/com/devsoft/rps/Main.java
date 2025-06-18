package com.devsoft.rps;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int gameCounts = 100;
        Player playerA = new Player("Spieler A", PlayMove.PAPER);
        Player playerB = new Player("Spieler B", PlayMove.values());

        Map<Player, List<Game.Result>> results = new LinkedHashMap<>();

        for (int i = 0; i < gameCounts; i++) {
            Game game = new Game(playerA, playerB);
            Player winner = game.playAndReturnWinner();
            if (winner == null) {
                results.computeIfAbsent(playerA, _ -> new ArrayList<>()).add(Game.Result.DRAW);
                results.computeIfAbsent(playerB, _ -> new ArrayList<>()).add(Game.Result.DRAW);
            } else if (winner.equals(playerA)) {
                results.computeIfAbsent(playerA, _ -> new ArrayList<>()).add(Game.Result.WIN);
                results.computeIfAbsent(playerB, _ -> new ArrayList<>()).add(Game.Result.LOSE);
            } else {
                results.computeIfAbsent(playerA, _ -> new ArrayList<>()).add(Game.Result.LOSE);
                results.computeIfAbsent(playerB, _ -> new ArrayList<>()).add(Game.Result.WIN);
            }
        }

        StringBuilder resultSummary = new StringBuilder();
        resultSummary.append("\nResults after ").append(gameCounts).append(" games\n\n");
        results.forEach((player, playerResults) -> {
            resultSummary.append("Player: ").append(player.getName()).append("\n");
            resultSummary.append("Wins: ").append(playerResults.stream().filter(Game.Result.WIN::equals).count()).append("\n");
            resultSummary.append("Loses: ").append(playerResults.stream().filter(Game.Result.LOSE::equals).count()).append("\n");
            resultSummary.append("Draws: ").append(playerResults.stream().filter(Game.Result.DRAW::equals).count()).append("\n\n\n");
        });
        log.info(resultSummary.toString());
    }
}
