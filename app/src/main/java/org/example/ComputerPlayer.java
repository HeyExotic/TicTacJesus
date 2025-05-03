package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {
     private final Random random = new Random();

    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    public int getMove(Board board, char opponentSymbol) {
        char[][] currentBoard = board.getBoard();
        
        if (isBoardEmpty(currentBoard)) {
            int[] corners = {0, 2, 6, 8};
            return corners[random.nextInt(corners.length)] + 1;
        }

        if (isSecondMove(currentBoard)) {
            if (currentBoard[1][1] == '5') {
                return 5;
            }
        }

        int winningMove = findWinningMove(board, getSymbol());
        if (winningMove != -1) {
            return winningMove;
        }

        int blockingMove = findWinningMove(board, opponentSymbol);
        if (blockingMove != -1) {
            return blockingMove;
        }

        return getRandomMove(board);
    }

    private boolean isBoardEmpty(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != ('1' + i * 3 + j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSecondMove(char[][] board) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != ('1' + i * 3 + j)) {
                    count++;
                }
            }
        }
        return count == 1;
    }

    private int findWinningMove(Board board, char symbol) {
        for (int i = 1; i <= 9; i++) {
            if (board.isCellEmpty(i)) {
                char[][] testBoard = copyBoard(board.getBoard());
                int row = (i - 1) / 3;
                int col = (i - 1) % 3;
                testBoard[row][col] = symbol;
                if (checkWinCondition(testBoard, symbol)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean checkWinCondition(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        return board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;
    }

    private int getRandomMove(Board board) {
        List<Integer> emptyCells = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (board.isCellEmpty(i)) {
                emptyCells.add(i);
            }
        }
        return emptyCells.get(random.nextInt(emptyCells.size()));
    }

    private char[][] copyBoard(char[][] original) {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, 3);
        }
        return copy;
    }
}
