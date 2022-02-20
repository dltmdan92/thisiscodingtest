package floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FloydWarshallV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/floyd_warshall/FloydWarshall.txt"));
        int nodeCnt = Integer.parseInt(bufferedReader.readLine());
        int lineCnt = Integer.parseInt(bufferedReader.readLine());

        int[][] lines = new int[nodeCnt + 1][nodeCnt + 1];

        for (int i = 0; i < lineCnt; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int startNode = line[0];
            int destNode = line[1];
            int cost = line[2];
            lines[startNode][destNode] = cost;
        }

        // define costs and initialize
        int[][] costs = new int[nodeCnt + 1][nodeCnt + 1];
        for (int startNode = 1; startNode < lines.length; startNode++) {
            for (int destNode = 1; destNode < lines[startNode].length; destNode++) {

                if (startNode == destNode) {
                    costs[startNode][destNode] = 0;
                }
                else if (lines[startNode][destNode] == 0) {
                    costs[startNode][destNode] = 100_000;
                }
                else {
                    costs[startNode][destNode] = lines[startNode][destNode];
                }
            }
        }


        for (int visitNode = 1; visitNode <= nodeCnt; visitNode++) {
            for (int startNode = 1; startNode <= nodeCnt; startNode++) {
                for (int endNode = 1; endNode <= nodeCnt; endNode++) {
                    costs[startNode][endNode] = Math.min(costs[startNode][endNode], costs[startNode][visitNode] + costs[visitNode][endNode]);
                }
            }
        }

        for (int[] c:costs) {
            System.out.println(Arrays.toString(c));
        }
    }


}
