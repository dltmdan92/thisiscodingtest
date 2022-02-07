package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UpDownLeftRight {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/implementation/up_down_left_right_param.txt"));

        int n = Integer.parseInt(bufferedReader.readLine());

        String line = bufferedReader.readLine();
        String[] operations = line.split(" ");

        int currentRow = 1;
        int currentCol = 1;

        for (String operation : operations) {
            int rowMove = 0;
            int colMove = 0;

            switch (operation) {
                case "L":
                    colMove = -1;
                    break;
                case "R":
                    colMove = 1;
                    break;
                case "U":
                    rowMove = -1;
                    break;
                case "D":
                    rowMove = 1;
                    break;
                default:
                    break;
            }

            int rowToMove = currentRow + rowMove;
            int colToMove = currentCol + colMove;

            if ((rowToMove >= 1 && rowToMove <= n) && (colToMove >= 1 && colToMove <= n)) {
                currentRow = rowToMove;
                currentCol = colToMove;
            }
        }

        System.out.println(currentRow + " " + currentCol);
    }

}
