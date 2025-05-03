package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameLog {
    private final Map<String, Integer> playerWins = new HashMap<>();
    private int ties = 0;
    private String player1Symbol = "X";
    private String player2Symbol = "O";

    public void setPlayerSymbols(String symbol1, String symbol2) {
        this.player1Symbol = symbol1;
        this.player2Symbol = symbol2;
    }

    public void recordGame(String winner) {
        if ("Tie".equals(winner)) {
            ties++;
        } else {
            playerWins.put(winner, playerWins.getOrDefault(winner, 0) + 1);
        }
    }

    public void displayStats() {
        System.out.println("\n=== Game Statistics ===");
        System.out.println("Player " + player1Symbol + " wins: " + playerWins.getOrDefault(player1Symbol, 0));
        System.out.println("Player " + player2Symbol + " wins: " + playerWins.getOrDefault(player2Symbol, 0));
        System.out.println("Ties: " + ties);
        System.out.println("Total games played: " + (playerWins.values().stream().mapToInt(i -> i).sum() + ties));
        System.out.println("======================");
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("tic_tac_toe_log.txt")) {
            writer.write("=== Tic-Tac-Toe Game Log ===\n");
            writer.write("Player " + player1Symbol + " wins: " + playerWins.getOrDefault(player1Symbol, 0) + "\n");
            writer.write("Player " + player2Symbol + " wins: " + playerWins.getOrDefault(player2Symbol, 0) + "\n");
            writer.write("Ties: " + ties + "\n");
            writer.write("Total games played: " + (playerWins.values().stream().mapToInt(i -> i).sum() + ties) + "\n");
            writer.write("===========================");
            System.out.println("Game log saved to tic_tac_toe_log.txt");
        } catch (IOException e) {
            System.out.println("Error saving game log: " + e.getMessage());
        }
    }

    public int getWinsForPlayer(String symbol) {
        return playerWins.getOrDefault(symbol, 0);
    }

    public int getTies() {
        return ties;
    }
}