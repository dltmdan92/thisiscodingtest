package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class IceBeverageV2 {

    private static int rows = 0;
    private static int cols = 0;

    public static void main(String[] args) throws IOException {
        int row = 0;
        int col = 0;
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/bfs/Beverage.txt"));
        String[] settings = bufferedReader.readLine().split(" ");
        rows = Integer.parseInt(settings[0]);
        cols = Integer.parseInt(settings[1]);

        int[][] map = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = bufferedReader.readLine();

            int[] ints = Arrays.stream(line.split(""))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            map[i] = ints;
        }

        // 동 서 남 북
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    count++;

                    dfs(i, j, map, dx, dy);
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int row, int col, int[][] map, int[] dx, int[] dy) {
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (isPositionRight(newRow, newCol)) {
                if (map[newRow][newCol] == 0) {
                    map[newRow][newCol] = 1;
                    dfs(newRow,newCol,map,dx,dy);
                }
            }
        }
    }

    private static boolean isPositionRight(int newRow, int newCol) {
        return newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols;
    }
}
