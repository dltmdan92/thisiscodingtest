package floyd_warshall;

import java.util.Arrays;
import java.util.List;

public class FutureCity {

    public static void main(String[] args) {

        String param = """
                2 5
                1 2
                1 3
                1 4
                2 4
                3 4
                3 5
                4 5
                """;

        List<int[]> lines = param.lines()
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toList();

        int k = lines.get(0)[0];
        int x = lines.get(0)[1];

        int[][] map = new int[x + 1][x + 1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= x; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1000000;
                }
            }
        }

        for (int i = 1; i < lines.size(); i++) {
            int[] line = lines.get(i);

            map[line[0]][line[1]] = 1;
        }

        for (int i = 1; i <= x; i++) {

            for (int a = 1; a <= x; a++) {
                for (int b = 0; b <= x; b++) {

                    map[a][b] = Math.min(map[a][b], map[a][i] + map[i][b]);

                }
            }

        }

        for (int i = 0; i < map.length; i++) {
            int[] xxx = map[i];
            System.out.println(Arrays.toString(xxx));
        }

        System.out.println();

        System.out.println(map[1][k]);
        System.out.println(map[k][x]);
    }

}
