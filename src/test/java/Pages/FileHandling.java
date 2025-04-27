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
    public void fileWrite(String Filename){
        String text = "Welcome to Capgemini\nHappy Working!";

        // Try block to check for exceptions
        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//            System.out.print("Enter the Path : ");
//
//            // Reading File name
//            String path = br.readLine();
            String fileNameNew="/MavenProject/demo/src/test/resources/files/"+Filename;
            Path p= Paths.get(fileNameNew);

            // Create an object of BufferedWriter
            BufferedWriter f_writer = new BufferedWriter(new FileWriter(p.toFile()));
            RandomAccessFile raf = new RandomAccessFile(fileNameNew, "rw");
            raf.setLength(0);
            // Write text(content) to file
            f_writer.write(text);

            // Printing the content inside the file
            // on the terminal/CMD
            System.out.print(text);

            // Close the BufferedWriter object
            f_writer.close();
        }

        // Catch block to handle if exceptions occurs
        catch (IOException e) {

            // Print the exception on console
            // using getMessage() method
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        FileHandling fileHandling=new  FileHandling();
        fileHandling.fileRead("FileNew.txt");
        fileHandling.fileWrite("FileWrite.txt");

    }

}
