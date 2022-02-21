package floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FutureCItyV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/floyd_warshall/FutureCity.txt"));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int nodeCount = Integer.parseInt(firstLine[0]);
        int lineCount = Integer.parseInt(firstLine[1]);

        int[][] costs = new int[nodeCount + 1][nodeCount + 1];

        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                costs[i][j] = 100_000;
            }
        }

        for (int i = 0; i < lineCount; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int startNode = Integer.parseInt(line[0]);
            int destNode = Integer.parseInt(line[1]);

            costs[startNode][destNode] = 1;
            costs[destNode][startNode] = 1;
        }

        String[] line = bufferedReader.readLine().split(" ");
        int A = 1;
        int K = Integer.parseInt(line[1]);
        int X = Integer.parseInt(line[0]);


        for (int startNode = 1; startNode <= nodeCount; startNode++) {
            for (int visitNode = 1; visitNode <= nodeCount; visitNode++) {
                for (int endNode = 1; endNode <= nodeCount; endNode++) {

                    costs[startNode][endNode] = Math.min(costs[startNode][endNode], costs[startNode][visitNode] + costs[visitNode][endNode]);

                }
            }
        }

        for (int[] cost:costs) {
            System.out.println(Arrays.toString(cost));
        }

        System.out.println(costs[A][K] + costs[K][X]);

    }

}
