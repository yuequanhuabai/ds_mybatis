package com.ex.test;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {

    @Test
    public void test1(){
//        String javaHome = System.getenv("JAVA_HOME");
        String javaHome = System.getenv("java_home");
        if(javaHome == null){
            System.out.println("JAVA_HOME is null");
            return;
        }
        Path path = Paths.get(javaHome+"/bin");

//        System.out.println( "path :"+path);

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for(Path file:stream){
                if(Files.isRegularFile(file)){
                    System.out.println(file.getFileName().toString());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
//            throw new RuntimeException(e);
        }


//        try
//            (Files.walk(path,1)){
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }
}
