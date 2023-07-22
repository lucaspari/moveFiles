package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FileManager {

    private File[] getFilesFromFolder(String folderPath) {
        File fileDownloader = new File(folderPath);
        return fileDownloader.listFiles();
    }
    public void moveFiles(String sourceFolder, String destinationFolder,List<String> allowedExtensions) {
        File[] files = getFilesFromFolder(sourceFolder);
        if (files == null) return;
        for (File file : files) {
            if (isFileWithAllowedExtension(file.getName(),allowedExtensions)){
                moveFile(file, destinationFolder);
            }
        }
    }

    private boolean isFileWithAllowedExtension(String name, List<String> allowedExtensions) {
        String fileExtension = getFileExtension(name);
        return allowedExtensions.contains(fileExtension);
    }
    private String getFileExtension(String name) {
        int dotIndex = name.lastIndexOf('.');
        return (dotIndex == -1) ? "" : name.substring(dotIndex + 1);
    }
    private void moveFile(File file, String destinationFolder) {
        try {
            Files.move(file.toPath(), Paths.get(destinationFolder, file.getName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.moveFiles("C:\\Users\\Lucas\\Downloads",
                "C:\\Users\\Lucas\\Documents\\",List.of("pdf","docx"));
    }


}
