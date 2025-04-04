package org.example;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final GameLog gameLog;

    public Game(GameLog gameLog, char player1Symbol, char player2Symbol) {
        this.board = new Board();
        this.player1 = new Player(player1Symbol);
        this.player2 = new Player(player2Symbol);
        this.currentPlayer = player1;
        this.gameLog = gameLog;
        this.gameLog.setPlayerSymbols(String.valueOf(player1Symbol), String.valueOf(player2Symbol));
    }

    public boolean checkWin(char symbol) {
        return board.checkWin(symbol);
    }

    public void startGame(Scanner scanner) {
        board.initializeBoard();
        System.out.println("\nStarting new game!");
        System.out.println("Player 1: " + player1.getSymbol());
        System.out.println("Player 2: " + player2.getSymbol());
        gameLog.displayStats();

        while (true) {
            board.displayBoard();
            int move = currentPlayer.getPlayerMove(scanner, board);
            board.makeMove(move, currentPlayer.getSymbol());

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.displayBoard();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins! Congratulations!");
                gameLog.recordGame(String.valueOf(currentPlayer.getSymbol()));
                gameLog.displayStats();
                switchStartingPlayer();
                break;
            } else if (board.checkDraw()) {
                board.displayBoard();
                System.out.println("The game is a draw!");
                gameLog.recordGame("Tie");
                gameLog.displayStats();
                switchStartingPlayer();
                break;
            }
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private void switchStartingPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        System.out.println("\nNext game will start with Player " + currentPlayer.getSymbol());
    }

    public Board getBoard() {
        return board;
    }
}