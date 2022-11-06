package FileAndGUI;
import java.io.*;


public class ReadAndWriteFile {

    public String[] readFile(String pathname) throws Exception {

        String line;
        String readLine = null;
        String writeLine = null;
        int sumLine = 0;
        //read text files
        File file = new File(pathname);
        BufferedReader read = new BufferedReader(new FileReader(file));
        while ((line = read.readLine()) != null && sumLine < 5) {
            //read first five line
            readLine += line + "\n";
            sumLine++;

            // write first three field of first five line
            String line1 = line.split(",")[0];
            String line2 = line.split(",")[1];
            String line3 = line.split(",")[2];
            writeLine += line1 + "," + line2 + "," + line3 + "\n";


        }
        String[] res = new String[2];
        res[0] = readLine;
        res[1] = writeLine;

        return res;
    }

    //write file
    public void write (String filename, String info) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(info);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

