package example.inoutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWrite {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("filename.text"))){
            bw.write("First line");
            bw.newLine();
            bw.write("Seccond line");
            System.out.println("Successfully wrote to the file");
        } catch (IOException e){
            System.out.println("Error writing file");
        }
    }
}
