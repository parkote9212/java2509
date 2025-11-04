package example.inoutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("bear.jpg");
             FileOutputStream output = new FileOutputStream("copy.jpg")){

            int i;
            while ((i = input.read()) != -1){
                output.write(i);
            }

            System.out.println("File copied successfully");

        } catch (IOException e){
            System.out.println("Error handling file");
        }
    }
}
