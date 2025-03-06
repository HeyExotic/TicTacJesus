package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testCheckWinRow() {
        char[][] winningBoard = {
            {'X', 'X', 'X'},
            {'4', 'O', '6'},
            {'7', '8', '9'}
        };
        game.setBoardState(winningBoard);
        assertTrue(game.checkWin()); 
    }

    @Test
    public void testCheckWinDiagonal() {  
        char[][] winningBoard = {
            {'X', '2', '3'},
            {'4', 'X', '6'},
            {'7', '8', 'X'}
        };
        game.setBoardState(winningBoard);
        assertTrue(game.checkWin()); 
    }

    @Test
    public void testCheckDraw() { 
        char[][] drawBoard = {
            {'X', 'O', 'X'},
            {'X', 'O', 'O'},
            {'O', 'X', 'X'}
        };
        game.setBoardState(drawBoard);
        assertTrue(game.checkDraw()); 
    }

    @Test
    public void testSwitchPlayer() {
        assertEquals('X', game.getCurrentPlayer().getSymbol()); 
        game.switchPlayer();
        assertEquals('O', game.getCurrentPlayer().getSymbol()); 
        game.switchPlayer();
        assertEquals('X', game.getCurrentPlayer().getSymbol());
    }
}