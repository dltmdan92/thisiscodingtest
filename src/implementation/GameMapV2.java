package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GameMapV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/implementation/GameMapArgs.txt"));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int cols = Integer.parseInt(firstLine[0]);
        int rows = Integer.parseInt(firstLine[1]);
        int[][] map = new int[rows][cols];

        String[] secondLine = bufferedReader.readLine().split(" ");
        int currentRow = Integer.parseInt(secondLine[0]);
        int currentCol = Integer.parseInt(secondLine[1]);
        int direction = Integer.parseInt(secondLine[2]);

        for (int i = 0; i < rows; i++) {
            String line  = bufferedReader.readLine();
            String[] points = line.split(" ");

            for (int j = 0; j < cols; j++) {
                String point = points[j];
                if ("1".equals(point)) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        int turnCount = 0;
        map[currentRow][currentCol] = 2;

        int total = 1;

        while(true) {
            // STEP 1. turnLeft & turnCount++
            direction = turnLeft(direction);
            turnCount++;
            // STEP 2. go
            int newRow = currentRow + dRow[direction];
            int newCol = currentCol + dRow[direction];
            if (map[newRow][newCol] == 0) {
                map[newRow][newCol] = 2;
                currentRow = newRow;
                currentCol = newCol;
                turnCount = 0;
                total++;
            }
            else {
                if (turnCount > 3) {
                    int beforeRow = currentRow - dRow[direction];
                    int beforeCol = currentCol - dCol[direction];

                    if (map[beforeRow][beforeCol] == 1) {
                        break;
                    }
                    else {
                        currentRow = beforeRow;
                        currentCol = beforeCol;
                        turnCount = 0;
                    }
                }
            }
        }

        System.out.println(total);
    }

    private static int turnLeft(int direction) {
        if (direction == 0)
            return 3;
        return direction - 1;
    }

}
