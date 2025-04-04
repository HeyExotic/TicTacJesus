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
        game = new Game(gameLog, 'X', 'O');
        board = game.getBoard();
    }

    @Test
    public void testBoardAccess() {
        assertNotNull(board);
        board.initializeBoard();
        assertEquals('1', board.getBoard()[0][0]);
    }

    @Test
    public void testWinRecording() {
        char[][] testBoard = {
            {'X', 'X', 'X'},
            {'4', 'O', '6'},
            {'7', '8', '9'}
        };
        board.setBoard(testBoard);
        assertTrue(game.checkWin('X'));
    }
}