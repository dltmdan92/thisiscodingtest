package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class GameMap {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/implementation/GameMapArgs.txt"));

        String mapInfo = bufferedReader.readLine();
        String[] mapInfos = mapInfo.split(" ");

        int rowCount = Integer.parseInt(mapInfos[0]);
        int colCount = Integer.parseInt(mapInfos[1]);

        String startInfo = bufferedReader.readLine();
        String[] startInfos = startInfo.split(" ");

        int startRow = Integer.parseInt(startInfos[0]);
        int startCol = Integer.parseInt(startInfos[1]);
        int startWay = Integer.parseInt(startInfos[2]);

        int[][] move = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        int[][] back = {{1,0},{0,-1},{-1,0},{0,1}};

        String[][] map = new String[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            String lineInfo = bufferedReader.readLine();
            String[] lineInfos = lineInfo.split(" ");
            map[i] = lineInfos;
        }

        int currentRow = startRow;
        int currentCol = startCol;
        int currentWay = startWay;
        int visitCount = 1;
        int turnCount = 0;
        boolean moveable = true;
        // 방문 했음
        map[currentRow][currentCol] = "2";

        while (moveable) {
            currentWay = turnLeft(currentWay);
            int movedRow = currentRow + move[currentWay][0];
            int movedCol = currentCol + move[currentWay][1];

            if (movedRow < rowCount && movedCol < colCount && map[movedRow][movedCol].equals("0")) {
                currentRow = movedRow;
                currentCol = movedCol;
                map[currentRow][currentCol] = "2";
                turnCount = 0;
                visitCount++;
            } else {
                if (turnCount < 3) {
                    turnCount++;
                } else {
                    int nRow = currentRow + back[currentWay][0];
                    int nCol = currentCol + back[currentWay][1];
                    if (!map[nRow][nCol].equals("1")) {
                        currentRow = currentRow + back[currentWay][0];
                        currentCol = currentCol + back[currentWay][1];
                        if (map[currentRow][currentCol].equals("0")) {
                            map[currentRow][currentCol] = "2";
                            visitCount++;
                        }
                    } else {
                        moveable = false;
                    }

                    turnCount = 0;
                }
            }
        }
        System.out.println(visitCount);
    }

    private static int turnLeft(int currentWay) {
        int way;
        if (currentWay > 0) {
            way = currentWay - 1;
        } else {
            way = 3;
        }
        return way;
    }

}
