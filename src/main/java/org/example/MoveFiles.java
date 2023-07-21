package org.example;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveFiles {

    public void moveFiles(String sourceFolder,String destinationFolder) {
        File fileDownloader = new File(sourceFolder);
        File[] files = fileDownloader.listFiles();
        if(files == null) return;
        for(File file : files){
            if(!isPDForDocx(file.getName())) continue;
            try{
                Files.move(file.toPath(), Paths.get(destinationFolder,file.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
            }catch (IOException error){
                System.out.println(error.getMessage());
            }

        }
    }
    public static boolean isPDForDocx(String name){
        return name.endsWith(".pdf") || name.endsWith(".docx");
    }

    public static void main(String[] args) {
        MoveFiles moveFiles = new MoveFiles();
        moveFiles.moveFiles("C:\\Users\\Lucas\\Downloads",
                "C:\\Users\\Lucas\\Documents\\");
    }


}
