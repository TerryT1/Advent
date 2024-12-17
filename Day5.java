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
        ArrayList<String> allMatches2 = new ArrayList<String>();

        String searchString = String.valueOf(fileData);
        String regex = "\\d+\\|\\d+";

        Matcher m = Pattern.compile(regex).matcher(searchString);
        while (m.find()) {
            allMatches.add(m.group());
        }
        System.out.println(allMatches);

        String searchString2 = String.valueOf(allMatches);
        String regex2 = "[1-9][0-9]";

        Matcher m2 = Pattern.compile(regex2).matcher(searchString2);
        while (m2.find()) {
            allMatches2.add(m2.group());
        }
        System.out.println(allMatches2);

        int sum = 0;

        for (int i = allMatches.size() + 1; i < fileData.size(); i++) {
            for (int j = 0; j < allMatches.size(); j++) {
                String[] spliter = allMatches.get(j).split("\\|");
                int num1 = Integer.parseInt(spliter[0]);
                int num2 = Integer.parseInt(spliter[1]);
                if (fileData.get(allMatches.size() + 1).substring(0, fileData.get(i).length()).indexOf(num2) > fileData.get(allMatches.size() + 1).substring(0, fileData.get(i).length()).indexOf(num1) )
                    sum += Integer.parseInt(fileData.get(allMatches.size() + 1).substring((fileData.get(i).length() + 1)/2 - 1), (fileData.get(i).length() + 1)/2);
                }
            }
        System.out.println(sum);
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