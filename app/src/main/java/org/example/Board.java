package org.example;

public class Board {
        private char[][] board = new char[3][3];
    
        public void initializeBoard() {
            int cellNumber = 1;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    board[row][col] = (char) ('0' + cellNumber++);
                }
            }
        }
    
        public void displayBoard() {
            System.out.println("\nCurrent Board:");
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    System.out.print(" " + board[row][col] + " ");
                    if (col < 2) System.out.print("|");
                }
                System.out.println();
                if (row < 2) System.out.println("-----------");
            }
            System.out.println();
        }
    
        public boolean isCellEmpty(int move) {
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            return Character.isDigit(board[row][col]);
        }
    
        public void makeMove(int move, char playerSymbol) {
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            board[row][col] = playerSymbol;
        }
    
        public boolean checkWin(char playerSymbol) {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == playerSymbol && board[i][1] == playerSymbol && board[i][2] == playerSymbol) return true;
                if (board[0][i] == playerSymbol && board[1][i] == playerSymbol && board[2][i] == playerSymbol) return true;
            }
            if (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) return true;
            return board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol;
        }

        public char[][] getBoard() {
            return board;
        }
    
        public void setBoard(char[][] newBoard) {
            for (int i = 0; i < 3; i++) {
                System.arraycopy(newBoard[i], 0, board[i], 0, 3);
            }
        }
    
        public boolean checkDraw() {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    char cell = board[row][col];
                    if (cell >= '1' && cell <= '9') {
                        return false;
                    }
                }
            }
            return !checkWin('X') && !checkWin('O');
        }
    }

