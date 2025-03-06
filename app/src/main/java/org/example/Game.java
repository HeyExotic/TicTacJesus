package org.example;
import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameOver;

    public Game() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        gameOver = false;
    }

    public void setBoardState(char[][] newBoard) {
        board = new Board();
        board.setBoard(newBoard);
    }
    
    public void startGame(Scanner scanner) {
        board.initializeBoard();
        System.out.println("Welcome to Tic-Tac-Toe!");

        while (!gameOver) {
            board.displayBoard();
            int move = currentPlayer.getPlayerMove(scanner, board);
            board.makeMove(move, currentPlayer.getSymbol());
            checkGameStatus();
            if (!gameOver) {
                switchPlayer();
            }
        }

        System.out.print("Do you want to play again? (yes/no): ");
        String playAgainInput = scanner.next().toLowerCase();
        if (playAgainInput.equals("yes")) {
            resetGame();
            startGame(scanner);
        } else {
            System.out.println("Thanks for playing Tic-Tac-Toe!");
        }
    }

   
    private void checkGameStatus() {
        if (checkWin()) {
            board.displayBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + " wins! Congratulations!");
            gameOver = true;
        } else if (checkDraw()) {
            board.displayBoard();
            System.out.println("The game is a draw!");
            gameOver = true;
        }
    }

    
    boolean checkWin() {
        char[][] boardState = board.getBoard();
        char symbol = currentPlayer.getSymbol();

   
        for (int i = 0; i < 3; i++) {
            if (boardState[i][0] == symbol && boardState[i][1] == symbol && boardState[i][2] == symbol) return true; 
            if (boardState[0][i] == symbol && boardState[1][i] == symbol && boardState[2][i] == symbol) return true; 
        }
        if (boardState[0][0] == symbol && boardState[1][1] == symbol && boardState[2][2] == symbol) return true;
        if (boardState[0][2] == symbol && boardState[1][1] == symbol && boardState[2][0] == symbol) return true; 
        return false;
    }


    boolean checkDraw() {
        char[][] boardState = board.getBoard();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (boardState[row][col] != 'X' && boardState[row][col] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

  
    void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }


    private void resetGame() {
        board.initializeBoard();
        currentPlayer = player1;
        gameOver = false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
