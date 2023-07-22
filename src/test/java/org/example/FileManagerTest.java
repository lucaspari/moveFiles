package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {


    @Test
    void isPDForDocx() {
        FileManager fileManager = new FileManager();
        assertTrue(fileManager.isPDForDocx("example.pdf"));
        assertTrue(fileManager.isPDForDocx("document.docx"));
        assertFalse(fileManager.isPDForDocx("image.jpg"));
    }

}