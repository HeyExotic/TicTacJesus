package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
        board.initializeBoard();
    }

    @Test
    public void testInitializeBoard() {
        char[][] expectedBoard = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    public void testIsCellEmpty() {
        assertTrue(board.isCellEmpty(1)); 
        board.makeMove(1, 'X');
        assertFalse(board.isCellEmpty(1)); 
    }

    @Test
    public void testMakeMove() {
        board.makeMove(5, 'X');
        assertEquals('X', board.getBoard()[1][1]); 
    }
}