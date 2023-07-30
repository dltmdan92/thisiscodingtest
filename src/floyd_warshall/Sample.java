package floyd_warshall;

import java.util.Arrays;
import java.util.List;

public class Sample {

    public static void main(String[] args) {
        String param = """
                4
                7
                1 2 4
                1 4 6
                2 1 3
                2 3 7
                3 1 5
                3 4 4
                4 3 2
                """;

        List<String> lines = param.lines().toList();

        int nodeCount = Integer.parseInt(lines.get(0));
        int edgeCount = Integer.parseInt(lines.get(1));

        int[][] map = new int[nodeCount+1][nodeCount+1];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 100000;
                }
            }
        }

        for (int i = 2; i < edgeCount + 2; i++) {
            int[] line = Arrays.stream(lines.get(i).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int start = line[0];
            int end = line[1];
            int distance = line[2];

            map[start][end] = distance;
        }


        for (int i = 1; i <= nodeCount; i++) {
            for (int a = 1; a <= nodeCount; a++) {
                for (int b = 1; b <= nodeCount; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][i] + map[i][b]);
                }
            }
        }

        for (int[] mapp : map) {
            System.out.println(Arrays.toString(mapp));
        }
    }

}
