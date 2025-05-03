package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;
    private GameLog gameLog;
    private Board board;

    @BeforeEach
    public void setUp() {
        gameLog = new GameLog();
        game = new Game(gameLog, 'X', 'O', false, false); // Human vs Human
        board = game.getBoard();
    }

    @Test
    public void testCheckWinHorizontal() {
        char[][] testBoard = {
            {'X', 'X', 'X'},
            {'4', 'O', '6'},
            {'7', '8', '9'}
        };
        board.setBoard(testBoard);
        assertTrue(game.checkWin('X'));
        assertFalse(game.checkWin('O'));
    }

    @Test
    public void testCheckWinVertical() {
        char[][] testBoard = {
            {'X', 'O', '3'},
            {'X', 'O', '6'},
            {'X', '8', '9'}
        };
        board.setBoard(testBoard);
        assertTrue(game.checkWin('X'));
        assertFalse(game.checkWin('O'));
    }

    @Test
    public void testCheckWinDiagonal() {
        char[][] testBoard = {
            {'X', 'O', '3'},
            {'4', 'X', '6'},
            {'7', '8', 'X'}
        };
        board.setBoard(testBoard);
        assertTrue(game.checkWin('X'));
        assertFalse(game.checkWin('O'));
    }

    @Test
    public void testGameInitialization() {
        assertEquals('X', game.getCurrentPlayer().getSymbol());
        assertNotNull(board);
    }
}