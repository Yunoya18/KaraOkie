/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author BBoonZ
 */
import java.io.*;

public class test {
    public static void main(String[] args) {
//        File foundFile = searchFile(System.getProperty("user.home"), "room.png");
        File directory = new File(System.getProperty("user.dir") + "/src/Karaokie/image/room.png");
        File[] files = directory.listFiles();
        if (files != null){
            for (File file : files) {
                System.out.println(file);
            }
        }
        System.out.println("Finish");
    }
    
    
    private static File searchFile(String directoryName, String filename) {
        File directory = new File(directoryName);

        // Get all files and directories in the current directory
        File[] files = directory.listFiles();
        if (files != null) {
            // Iterate through files and directories
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursive call to search within subdirectories
                    File foundFile = searchFile(file.getAbsolutePath(), filename);
                    if (foundFile != null) {
                        return foundFile; // If file is found, return it
                    }
                } else if (file.getName().equals(filename)) {
                    return file; // If file is found, return it
                }
            }
        }
        return null; // File not found
    }
}
