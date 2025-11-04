package example.inoutput;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args) {


        String text = "Hello World!";
        try (FileOutputStream output = new FileOutputStream("filename.txt")) {
            output.write(text.getBytes());
            System.out.println("Successfully wrote to file");
        } catch (IOException e){
            System.out.println("Error writing file.");
            e.printStackTrace();
        }

    }
}