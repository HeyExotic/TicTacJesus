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
        board = new Board();
        board.initializeBoard();
    }

    @Test
    public void testChooseSymbolValid() {
        String input = "A\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        
        char symbol = Player.chooseSymbol(scanner, "1");
        assertEquals('A', symbol);
    }

    @Test
    public void testChooseSymbolInvalidThenValid() {
        String input = "  \nB\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        
        char symbol = Player.chooseSymbol(scanner, "1");
        assertEquals('B', symbol);
    }

    @Test
    public void testGetPlayerMoveWithCustomSymbol() {
        player = new Player('@');
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int move = player.getPlayerMove(scanner, board);
        assertEquals(5, move);
    }
}