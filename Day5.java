import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<String> allMatches = new ArrayList<String>();

        String searchString = String.valueOf(fileData);
        String regex = "\\d+\\|\\d+";

        Matcher m = Pattern.compile(regex).matcher(searchString);
        while (m.find()) {
            allMatches.add(m.group());
        }
        System.out.println(allMatches);

        ArrayList<String> allMatches2 = new ArrayList<String>();
        String searchString2 = String.valueOf(allMatches);
        String regex2 = "[1-9][0-9]";

        Matcher m2 = Pattern.compile(regex2).matcher(searchString2);
        while (m2.find()) {
            allMatches2.add(m2.group());
        }
        System.out.println(allMatches2);

        int sum = 0;

        for (int i = allMatches.size(); i < fileData.size(); i++) {
            String[] pages = fileData.get(i).split(",");
            boolean correct = true;

            for (int j = 0; j < allMatches.size(); j++) {
                String[] ruleParts = allMatches.get(j).split("\\|");
                int num1 = Integer.parseInt(ruleParts[0]);
                int num2 = Integer.parseInt(ruleParts[1]);

                int num1i = indexOf(pages, num1);
                int num2i = indexOf(pages, num2);

                if (num1i != -1 && num2i != -1 && num1i > num2i) {
                    correct = false;
                    break;
                }
            }

            if (correct) {
                int middleIndex = pages.length / 2;
                int middlePage = Integer.parseInt(pages[middleIndex]);
                sum += middlePage;
            }
        }

        System.out.println(sum);
    }

    public static int indexOf(String[] pages, int page) {
        for (int i = 0; i < pages.length; i++) {
            if (Integer.parseInt(pages[i]) == page) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals("")) {
                    fileData.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            return fileData;
        }
        return fileData;
    }
}
