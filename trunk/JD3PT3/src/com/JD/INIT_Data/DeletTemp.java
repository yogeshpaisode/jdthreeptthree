/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.INIT_Data;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
/**
 *
 * @author Yogesh
 */
public class DeletTemp {

    public DeletTemp() {

        Path dir = Paths.get("temp");
        try {
            Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {                   
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir,
                        IOException exc) throws IOException  {                  
                    if (exc == null) {                      
                        return FileVisitResult.CONTINUE;
                    } else {
                        throw exc;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String a[]){
        new DeletTemp();
    }
}
