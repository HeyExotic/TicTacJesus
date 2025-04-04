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
    public void testIsCellEmptyWithCustomSymbols() {
        board.makeMove(1, '@');
        assertFalse(board.isCellEmpty(1));
        assertTrue(board.isCellEmpty(2));
    }

    @Test
    public void testMakeMoveWithCustomSymbol() {
        board.makeMove(5, '#');
        assertEquals('#', board.getBoard()[1][1]);
    }

    @Test
    public void testCheckWinWithCustomSymbol() {
        char[][] customBoard = {
            {'@', '@', '@'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };
        board.setBoard(customBoard);
        assertTrue(board.checkWin('@'));
    }
}