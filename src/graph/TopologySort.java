package graph;

import java.util.*;
import java.util.stream.Collectors;

public class TopologySort {

    public static void main(String[] args) {

        String param = """
                7 8
                1 2
                1 5
                2 3
                2 6
                3 4
                4 7
                5 6
                6 4
                """;

        List<Integer> firstLine = param.lines().limit(1L).findFirst()
                .map(line -> Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .toList())
                .get();
        int nodeCount = firstLine.get(0);
        int edgeCount = firstLine.get(1);

        List<Edge> edges = param.lines().skip(1L)
                .map(line -> Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .toList())
                .map(list -> new Edge(list.get(0), list.get(1)))
                .toList();

        Map<Integer, List<Integer>> map = edges.stream()
                .collect(Collectors.groupingBy(edge -> edge.start, Collectors.mapping(edge -> edge.end, Collectors.toList())));

        int[] entranceDegrees = new int[nodeCount + 1];

        for (Edge edge : edges) {
            entranceDegrees[edge.end]++;
        }

        System.out.println(Arrays.toString(entranceDegrees));

        List<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        int startNode = 0;
        for (int i = 1; i < entranceDegrees.length; i++) {
            if (entranceDegrees[i] == 0) {
                startNode = i;
                break;
            }
        }

        queue.add(startNode);

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            result.add(poll);

            List<Integer> ends = map.getOrDefault(poll, Collections.emptyList());

            for (int end : ends) {
                entranceDegrees[end]--;

                System.out.printf("index: %d, degree: %d\n", end, entranceDegrees[end]);

                if (entranceDegrees[end] == 0) {
                    queue.add(end);
                }
            }
        }

        System.out.println(result);
    }

    private static class Edge {
        private final int start;
        private final int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
