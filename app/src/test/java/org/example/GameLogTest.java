package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class GameLogTest {
    private GameLog gameLog;

    @BeforeEach
    public void setUp() {
        gameLog = new GameLog();
    }

    @Test
    public void testWinTracking() {
        gameLog.recordGame("X");
        gameLog.recordGame("O");
        assertEquals(1, gameLog.getWinsForPlayer("X"));
        assertEquals(1, gameLog.getWinsForPlayer("O"));
    }

    @Test
    public void testPersistentStats() {
        gameLog.recordGame("X");
        gameLog.recordGame("O");
        gameLog.recordGame("Tie");
  
        assertEquals(1, gameLog.getWinsForPlayer("X"));
        assertEquals(1, gameLog.getWinsForPlayer("O"));
        assertEquals(1, gameLog.getTies());
    }
}