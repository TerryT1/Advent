import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        int answer = 0;
        for (int i = 0; i < fileData.size(); i++) {
            answer += getAnswer(fileData.get(i));
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

    public static int getAnswer(String line) {
        String[] split = line.split("   ");
        int firstL = Integer.parseInt(split[0].split("   ")[0]);
        int secondL = Integer.parseInt(split[0].split("   ")[1]);
        return Math.abs(firstL - secondL);
    }
}