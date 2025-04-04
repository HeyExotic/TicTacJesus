package org.example;

import java.util.Scanner;

public class Player {
    private final char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public static char chooseSymbol(Scanner scanner, String playerNumber) {
        char symbol;
        while (true) {
            System.out.print("Player " + playerNumber + ", choose your symbol (single character): ");
            String input = scanner.next();
            if (input.length() == 1) {
                symbol = input.charAt(0);
                if (symbol != ' ' && symbol != '\t' && symbol != '\n') {
                    return symbol;
                }
            }
            System.out.println("Invalid symbol. Please enter a single visible character.");
        }
    }

    public char getSymbol() {
        return symbol;
    }

    public int getPlayerMove(Scanner scanner, Board board) {
        int move = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Player " + symbol + ", enter your move (1-9): ");
            if (scanner.hasNextInt()) {
                move = scanner.nextInt();
                if (move >= 1 && move <= 9 && board.isCellEmpty(move)) {
                    validInput = true;
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                scanner.next();
            }
        }

        return move;
    }
}