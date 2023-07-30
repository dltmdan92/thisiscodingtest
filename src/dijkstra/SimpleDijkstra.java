package dijkstra;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleDijkstra {

    public static void main(String[] args) {
        String param = """
                6 11
                1
                1 2 2
                1 3 5
                1 4 1
                2 3 3
                2 4 2
                3 2 3
                3 6 5
                4 3 3
                4 5 1
                5 3 1
                5 6 2
                """;

        List<String> lines = param.lines().collect(Collectors.toList());

        int[] firstLine = Arrays.stream(lines.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startNode = Integer.parseInt(lines.get(1));

        int[][] edges = new int[firstLine[1]][3];

        for (int i = 2; i < lines.size(); i++) {
            int[] line = Arrays.stream(lines.get(i).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            edges[i - 2] = line;
        }

        int[] dp = new int[firstLine[0] + 1];

        for (int i = 1; i < dp.length; i++) {
            if (i != startNode) {
                dp[i] = Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int distance = edge[2];

            int oneToStart = dp[start];

            int oneToEndDistance = oneToStart + distance;
            dp[end] = Math.min(oneToEndDistance, dp[end]);
        }

        for (int i = 1; i < dp.length; i++) {
            int d = dp[i];
            System.out.println(d);
        }

    }

    public static class Node {
        private final int target;
        private final int distance;

        public Node(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }
    }

}
