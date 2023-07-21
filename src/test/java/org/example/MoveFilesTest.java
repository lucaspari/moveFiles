package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MoveFilesTest {


    @Test
    void isPDForDocx() {
        MoveFiles moveFiles = new MoveFiles();
        assertTrue(moveFiles.isPDForDocx("example.pdf"));
        assertTrue(moveFiles.isPDForDocx("document.docx"));
        assertFalse(moveFiles.isPDForDocx("image.jpg"));
    }

}