
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day7Input.txt");
        System.out.println(fileData);
        int lineTotal = 0;
        for (String line : fileData) {
            String[] splitter = line.split(": ");
            float num1 = Float.parseFloat(splitter[0]);
            String[] splitter2 = splitter[1].split(" ");
            for (int i = 0; i < splitter2.length && lineTotal != num1; i++) {
                lineTotal += Integer.parseInt(splitter2[i]);
                if (lineTotal != num1) {
                    lineTotal = 0;
                }
            }
        }
        System.out.println(lineTotal);
    }






    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}