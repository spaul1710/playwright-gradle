package Pages;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandling {
    public void fileRead(String fileName) throws IOException {
        String fileNameNew="/MavenProject/demo/src/test/resources/files/"+fileName;
        Path p= Paths.get(fileNameNew);
        File file=new File(p.toUri());
        FileReader reader= new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(reader);
        String text=bufferedReader.readLine();
        System.out.println("File read Text:\n "+ text);
    }
    public static void main(String[] args) throws IOException {
        FileHandling fileHandling=new  FileHandling();
        fileHandling.fileRead("FileNew.txt");

    }

}
