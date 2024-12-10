import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("Day3Input.txt");

        // build a 2D Array based on the length of each string and the size of the list
        // e.g
        // ABCD
        // EFGH
        // IJKL
        // This would be a 3 row, 4 column 2D array
        int sum = 0;
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c + 1);
            }
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (c + 3 < grid[0].length && (grid[r][c] + grid[r][c + 1] + grid[r][c + 2] + grid[r][c + 3]).equals("XMAS")) {
                    sum++;
                }

                if (r + 3 < grid.length && (grid[r][c] + grid[r + 1][c] + grid[r + 2][c] + grid[r + 3][c]).equals("XMAS")) {
                    sum++;
                }

                if (r + 3 < grid.length && c + 3 < grid[0].length && (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] + grid[r + 3][c + 3]).equals("XMAS")) {
                    sum++;
                }

                if (r + 3 < grid.length && c - 3 >= 0 && (grid[r][c] + grid[r + 1][c - 1] + grid[r + 2][c - 2] + grid[r + 3][c - 3]).equals("XMAS")) {
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