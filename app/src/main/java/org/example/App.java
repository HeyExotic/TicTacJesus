package org.example;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameLog gameLog = new GameLog();
        boolean playAgain = true;

        System.out.println("=== Tic-Tac-Toe ===");
        
        while (playAgain) {
            boolean isAgainstComputer = chooseGameMode(scanner);
            boolean computerFirst = false;
            
            if (isAgainstComputer) {
                computerFirst = chooseComputerOrder(scanner);
            }

            System.out.println("\nChoose your symbols:");
            char player1Symbol = Player.chooseSymbol(scanner, "1");
            char player2Symbol;
            do {
                player2Symbol = Player.chooseSymbol(scanner, "2");
                if (player2Symbol == player1Symbol) {
                    System.out.println("Symbol must be different from Player 1's symbol.");
                }
            } while (player2Symbol == player1Symbol);

            Game game = new Game(gameLog, player1Symbol, player2Symbol, isAgainstComputer, computerFirst);
            game.startGame(scanner);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String input = scanner.next();
            while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");
                input = scanner.next();
            }
            playAgain = input.equalsIgnoreCase("yes");
        }

        gameLog.saveToFile();
        System.out.println("\nThank you for playing!");
        scanner.close();
    }

    private static boolean chooseGameMode(Scanner scanner) {
        System.out.println("\nChoose game mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.print("Enter your choice (1-2): ");
        
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    return choice == 2;
                }
            } else {
                scanner.next();
            }
            System.out.print("Invalid input. Please enter 1 or 2: ");
        }
    }

    private static boolean chooseComputerOrder(Scanner scanner) {
        System.out.println("\nChoose computer order:");
        System.out.println("1. Computer goes first");
        System.out.println("2. Computer goes second");
        System.out.print("Enter your choice (1-2): ");
        
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    return choice == 1;
                }
            } else {
                scanner.next();
            }
            System.out.print("Invalid input. Please enter 1 or 2: ");
        }
    }
}