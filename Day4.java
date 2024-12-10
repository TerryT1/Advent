import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("Day3Input.txt");

        int sum = 0;
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                grid[r][c] = fileData.get(r).substring(c, c + 1);
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (c + 3 < columns && (grid[r][c] + grid[r][c + 1] + grid[r][c + 2] + grid[r][c + 3]).equals("XMAS")) {
                    sum++;
                }
                if (r + 3 < rows && (grid[r][c] + grid[r + 1][c] + grid[r + 2][c] + grid[r + 3][c]).equals("XMAS")) {
                    sum++;
                }
                if (r + 3 < rows && c + 3 < columns && (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] + grid[r + 3][c + 3]).equals("XMAS")) {
                    sum++;
                }
                if (r + 3 < rows && c - 3 >= 0 && (grid[r][c] + grid[r + 1][c - 1] + grid[r + 2][c - 2] + grid[r + 3][c - 3]).equals("XMAS")) {
                    sum++;
                }
                if (c - 3 >= 0 && (grid[r][c] + grid[r][c - 1] + grid[r][c - 2] + grid[r][c - 3]).equals("XMAS")) {
                    sum++;
                }
                if (r - 3 >= 0 && (grid[r][c] + grid[r - 1][c] + grid[r - 2][c] + grid[r - 3][c]).equals("XMAS")) {
                    sum++;
                }
                if (r - 3 >= 0 && c - 3 >= 0 && (grid[r][c] + grid[r - 1][c - 1] + grid[r - 2][c - 2] + grid[r - 3][c - 3]).equals("XMAS")) {
                    sum++;
                }
                if (r - 3 >= 0 && c + 3 < columns && (grid[r][c] + grid[r - 1][c + 1] + grid[r - 2][c + 2] + grid[r - 3][c + 3]).equals("XMAS")) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }



    // "grid" represents a 2D array of Strings built from the input file


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