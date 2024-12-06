import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day1Input.txt");

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (String line : fileData) {
            String[] num = line.split("\\s+");
            left.add(Integer.parseInt(num[0]));
            right.add(Integer.parseInt(num[1]));
        }

        Collections.sort(left);
        Collections.sort(right);

        int sum = 0;
        for (int i = 0; i < left.size(); i++) {
            sum += Math.abs(left.get(i) - right.get(i));
        }

        System.out.println(sum);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals("")) {
                    fileData.add(line);
                }
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
