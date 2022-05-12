package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextFileManagerTest {
    static final TextFileManager manageMap = new TextFileManager();

    @Test
    void getSquareMapDimension() {
        assertEquals(20, manageMap.getSquareMapDimension());
    }
}