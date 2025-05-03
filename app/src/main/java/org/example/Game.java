package org.example;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final GameLog gameLog;
    private final boolean isAgainstComputer;
    private final boolean computerFirst;

    public Game(GameLog gameLog, char player1Symbol, char player2Symbol, 
                boolean isAgainstComputer, boolean computerFirst) {
        this.board = new Board();
        this.isAgainstComputer = isAgainstComputer;
        this.computerFirst = computerFirst;
        
        if (isAgainstComputer) {
            if (computerFirst) {
                this.player1 = new ComputerPlayer(player1Symbol);
                this.player2 = new Player(player2Symbol);
            } else {
                this.player1 = new Player(player1Symbol);
                this.player2 = new ComputerPlayer(player2Symbol);
            }
        } else {
            this.player1 = new Player(player1Symbol);
            this.player2 = new Player(player2Symbol);
        }
        
        this.currentPlayer = player1;
        this.gameLog = gameLog;
        this.gameLog.setPlayerSymbols(String.valueOf(player1Symbol), String.valueOf(player2Symbol));
    }

    public void startGame(Scanner scanner) {
        board.initializeBoard();
        System.out.println("\nStarting new game!");
        
        if (isAgainstComputer) {
            System.out.println("Playing against computer");
            System.out.println("Computer is: " + (computerFirst ? player1.getSymbol() : player2.getSymbol()));
        }
        
        System.out.println("Player 1: " + player1.getSymbol());
        System.out.println("Player 2: " + player2.getSymbol());
        gameLog.displayStats();
    
        while (true) {
            board.displayBoard();

            if (board.checkDraw()) {
                handleTie();
                break;
            }
            
            int move;
            if (currentPlayer instanceof ComputerPlayer) {
                System.out.println("Computer (" + currentPlayer.getSymbol() + ") is thinking...");
                char opponentSymbol = (currentPlayer == player1) ? player2.getSymbol() : player1.getSymbol();
                move = ((ComputerPlayer) currentPlayer).getMove(board, opponentSymbol);
                System.out.println("Computer chooses position " + move);
            } else {
                move = currentPlayer.getPlayerMove(scanner, board);
            }
            
            board.makeMove(move, currentPlayer.getSymbol());
    
            if (board.checkWin(currentPlayer.getSymbol())) {
                handleWin();
                break;
            }
            
            if (board.checkDraw()) {
                handleTie();
                break;
            }
            
            switchPlayer();
        }
    }
    
    private void handleWin() {
        board.displayBoard();
        String winner = String.valueOf(currentPlayer.getSymbol());
        System.out.println("Player " + winner + " wins! Congratulations!");
        gameLog.recordGame(winner);
        gameLog.displayStats();
        switchStartingPlayer();
    }
    
    private void handleTie() {
        board.displayBoard();
        System.out.println("The game is a draw!");
        gameLog.recordGame("Tie");
        gameLog.displayStats();
        switchStartingPlayer();
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
    public boolean checkWin(char symbol) {
        return board.checkWin(symbol);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}