
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day7Input.txt");
        System.out.println(fileData);
        for (String line: fileData) {
            String[] splitter = line.split(": ");
            int num1 = Integer.parseInt(splitter[0]);
            String[] commaSplitter = splitter[1].split(" ");
            int lineTotal = 0;
            for (int i = 0; i < commaSplitter.length && lineTotal != num1; i++) {
                lineTotal += Integer.parseInt(commaSplitter[i]);
                lineTotal *= Integer.parseInt(commaSplitter[i]);
            }
        }


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
