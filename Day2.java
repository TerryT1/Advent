import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        System.out.println(fileData);
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!
        boolean a = true;
        int total = 0;
        for (int i = 0; i < fileData.size(); i++) {
            if (safe(fileData.get(i)) == a) {
                total++;
            }
        }
        System.out.println(total);
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

    public static boolean safe(String line) {
        String[] splitData = line.split(" ");
        for (int i = 0; i < splitData.length; i++) {
            if ((Integer.parseInt(splitData[i]) > Integer.parseInt(splitData[i + 1]) && (Integer.parseInt(splitData[i])  <= Integer.parseInt(splitData[i + 1]) + 3))) {
                return true;
            }
            else if ((Integer.parseInt(splitData[i]) < Integer.parseInt(splitData[i + 1]) && (Integer.parseInt(splitData[i]) + 3 >= Integer.parseInt(splitData[i + 1])))) {
                return true;
            }
            return false;
        }
        return false;
    }

}