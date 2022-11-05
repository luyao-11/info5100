package FileAndGUI;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAndWriteFile {


    public ArrayList<String> readFile(String path) {
        ArrayList<String> content = new ArrayList<>();
        int numLine = 5;
        try {
            //read text files
            File file = new File(path);
            Scanner scanner1 = new Scanner(file);
            //scan first five line in a file
            for (int i = 0; i < numLine; i++) {
                String data = scanner1.nextLine();
                content.add(data);
                System.out.println(data);
            }
            scanner1.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load file");
            e.printStackTrace();
        }
        return content;
    }


    public ArrayList<String> writeFile(String path, String writingPath) {
        ArrayList<String> writeContent = new ArrayList<>();
        try {
            String[] array;
            File myFile = new File(path);
            Scanner myScanner = new Scanner(myFile);
            FileWriter myWriter = new FileWriter(writingPath);
            BufferedWriter myBwriter = new BufferedWriter(myWriter);
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                array = data.split(",");

            }


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}





