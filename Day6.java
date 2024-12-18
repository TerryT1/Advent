import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day6Input.txt");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                grid[r][c] = fileData.get(r).substring(c, c + 1);
            }
        }
        int sum = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                    if (grid[r][c].equals("^") && !grid[r][c].equals(grid[rows - 1][c]) && !grid[r][c].equals(grid[r][columns - 1])) {
                        int tempR = r;
                        int tempC = c;
                        while (tempR > 0 && !grid[tempR - 1][tempC].equals("#")) {
                            grid[tempR][tempC].equals("^");
                            sum++;
                            tempR--;
                        }
                        while (tempC > 0 && !grid[tempR][tempC + 1].equals("#")) {
                            grid[tempR][tempC].equals("^");
                            sum++;
                            tempC++;
                        }
                        while (tempR > 0 && !grid[tempR + 1][tempC].equals("#")) {
                            grid[tempR][tempC].equals("^");
                            sum++;
                            tempR++;
                        }
                        while (tempC > 0 && !grid[tempR][tempC - 1].equals("#")) {
                            grid[tempR][tempC].equals("^");
                            sum++;
                            tempC--;
                        }

                    }
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
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}

