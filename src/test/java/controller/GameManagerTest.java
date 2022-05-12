package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    final GameManager manageGame = new GameManager();
    final TextFileManager manageMap = new TextFileManager();
    final char[][] map = manageMap.create2dArray();

    @Test
    void checkStartingPositionTrue() {
        assertTrue(manageGame.checkStartingPosition(map, 3, 0, null));
    }

    @Test
    void checkStartingPositionFalse() {
        assertFalse(manageGame.checkStartingPosition(map, 23, 9, null));
    }

    @Test
    void checkColission() {
        assertFalse(manageGame.checkColission(map, 2, 0));
        assertFalse(manageGame.checkColission(map, 22, 3));
        assertTrue(manageGame.checkColission(map, 3, 0));
    }
}