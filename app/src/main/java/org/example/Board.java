package org.example;

public class Board {
        private char[][] board = new char[3][3];
    
        public void setBoard(char[][] newBoard) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    board[row][col] = newBoard[row][col];
                }
            }
        }
    
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
            return board[row][col] != 'X' && board[row][col] != 'O';
        }
    
     
        public void makeMove(int move, char playerSymbol) {
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            board[row][col] = playerSymbol;
        }
    
       
        public char[][] getBoard() {
            return board;
        }
    }

