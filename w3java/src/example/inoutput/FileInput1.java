package example.inoutput;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInput1 {
    public static void main(String[] args) {
        try (FileInputStream imput = new FileInputStream("filename.txt")){

            int i;
//            파일에서 데이터를 1바이트씩 읽어온다
            while ((i = imput.read()) != -1){
                System.out.print((char)i);
            }
        } catch (IOException e){
            System.out.println("Error reading file");
        }
    }
}
