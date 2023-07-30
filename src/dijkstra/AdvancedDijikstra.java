package dijkstra;

import java.util.*;
import java.util.stream.Collectors;

public class AdvancedDijikstra {

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

        int[] dp = new int[firstLine[0] + 1];
        List<List<Node>> map = new LinkedList<>();
        for (int i = 0; i <= firstLine[0]; i++) {
            map.add(new LinkedList<>());
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(x -> x.distance));

        for (int i = 2; i < lines.size(); i++) {
            int[] line = Arrays.stream(lines.get(i).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int start = line[0];
            int end = line[1];
            int distance = line[2];

            map.get(start).add(new Node(end, distance));
        }

        pq.add(new Node(startNode, 0));

        boolean[] visited = new boolean[firstLine[0] + 1];

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (visited[poll.target]) {
                continue;
            } else {
                visited[poll.target] = true;
            }

            List<Node> nodes = map.get(poll.target);

            dp[poll.target] = Math.min(poll.distance, dp[poll.target]);

            nodes.forEach(node -> pq.add(new Node(node.target, node.distance + dp[poll.target])));
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
