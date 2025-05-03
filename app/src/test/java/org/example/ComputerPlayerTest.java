package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerPlayerTest {
     private ComputerPlayer computer;
    private Board board;
    private char humanSymbol = 'O';
    
    @BeforeEach
    public void setUp() {
        computer = new ComputerPlayer('X');
        board = new Board();
        board.initializeBoard();
    }

    @Test
    public void testFirstMoveChoosesCorner() {
        int move = computer.getMove(board, humanSymbol);
        assertTrue(move == 1 || move == 3 || move == 7 || move == 9);
    }

    @Test
    public void testSecondMoveTakesCenter() {
    
        board.makeMove(1, 'X');
        int move = computer.getMove(board, humanSymbol);
        assertEquals(5, move);
    }

    @Test
    public void testWinningMove() {
     
        board.makeMove(1, 'X');
        board.makeMove(2, 'X');
        int move = computer.getMove(board, humanSymbol);
        assertEquals(3, move); 
    }

    @Test
    public void testBlockingMove() {
        board.makeMove(1, 'O');
        board.makeMove(2, 'O');
        int move = computer.getMove(board, humanSymbol);
        assertEquals(3, move); 
    }

    @Test
    public void testRandomMoveWhenNoStrategy() {
        board.makeMove(1, 'X');
        board.makeMove(2, 'O');
        board.makeMove(3, 'X');
        board.makeMove(5, 'O');
        int move = computer.getMove(board, humanSymbol);
        assertTrue(move >= 4 && move <= 9 && move != 5);
    }
}
