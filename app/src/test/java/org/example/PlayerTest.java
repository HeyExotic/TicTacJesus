package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class PlayerTest {
    private Player player;
    private Board board;

    @BeforeEach
    public void setUp() {
        player = new Player('X');
        board = new Board();
        board.initializeBoard();
    }

    @Test
    public void testGetPlayerMoveValid() {
        String input = "5\n"; 
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int move = player.getPlayerMove(scanner, board);
        assertEquals(5, move);
    }

    @Test
    public void testGetPlayerMoveInvalidThenValid() {
        String input = "10\n5\n"; 
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int move = player.getPlayerMove(scanner, board);
        assertEquals(5, move); 
    }
}