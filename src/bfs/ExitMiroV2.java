package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ExitMiroV2 {

    private static int rows = 0;
    private static int cols = 0;

    public static void main(String[] args) throws IOException {
        int row = 0;
        int col = 0;

        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/bfs/ExitMiro.txt"));

        String[] s = bufferedReader.readLine().split(" ");
        rows = Integer.parseInt(s[0]);
        cols = Integer.parseInt(s[1]);

        int[][] map = new int[rows][cols];

        // 동 서 남 북
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for (int i = 0; i < rows; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(""))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(Node.getNode(row, col));
        map[row][col] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nodeRow = node.getRow();
                int nodeCol = node.getCol();

                int newRow = nodeRow + dx[i];
                int newCol = nodeCol + dy[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (map[newRow][newCol] == 1) {
                        map[newRow][newCol] = map[nodeRow][nodeCol] + 1;
                        queue.add(Node.getNode(newRow, newCol));
                    }

                }
            }
        }

        System.out.println(map[rows - 1][cols - 1]);

    }

    private static class Node {
        private int row;
        private int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        private static Node getNode(int row, int col) {
            return new Node(row, col);
        }
    }

}
