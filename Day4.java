import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day4Input");
        System.out.println(fileData);
        int count = 0;
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                if ((fileData.get(i) + fileData.get(i + 1) + fileData.get(i + 2) + fileData.get(i + 3)).equals("XMAX")) {
                    i++;
                }
                count++;
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