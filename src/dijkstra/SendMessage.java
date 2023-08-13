package dijkstra;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SendMessage {
    private static final int MAX = 30000;

    public static void main(String[] args) {

        String param = """
                7 2 1
                1 2 4
                1 3 2
                1 4 5
                2 4 5
                2 6 7
                3 6 5
                3 5 7
                3 4 2
                4 5 3
                4 7 9
                5 6 3
                6 7 2
                2 7 4
                7 4 5
                7 5 2
                """;


        List<Integer> firstLine = param.lines().limit(1L).findFirst()
                .map(str -> Arrays.stream(str.split(" "))
                        .map(Integer::parseInt)
                        .toList())
                .get();

        int N = firstLine.get(0); // 도시의 개수
        int M = firstLine.get(1); // 통로의 개수
        int C = firstLine.get(2); // 보내는 도시

        // key: startNode, value: [target, distance] list
        Map<Integer, List<Destination>> map = param.lines().skip(1L)
                .map(str -> Arrays.stream(str.split(" "))
                        .map(Integer::parseInt)
                        .toList())
                .collect(Collectors.groupingBy(x -> x.get(0), Collectors.mapping(x -> new Destination(x.get(1), x.get(2)), Collectors.toList())));

        int[][] distances = new int[N + 1][N + 1];

        for (int[] distance : distances) {
            Arrays.fill(distance, MAX);
            System.out.println(Arrays.toString(distance));
        }

        for (Integer startNode : map.keySet()) {
            System.out.println("startNode: " + startNode);
            List<Destination> destinations = map.get(startNode);

            destinations.forEach(destination -> distances[startNode][destination.target] = Math.min(distances[startNode][destination.target], destination.distance));
        }

        for (int[] distance : distances) {
            System.out.println(Arrays.toString(distance));
        }

        System.out.println("map start");
        for (int mid = 1; mid <= N; mid++) {
            for (int start = 1; start <= N; start++) {
                if (mid == start) {
                    continue;
                }

                for (int end = 1; end <= N; end++) {
                    if (mid == end) {
                        continue;
                    }

                    distances[start][end] = Math.min(distances[start][end], distances[start][mid] + distances[mid][end]);
                }
            }
        }

        for (int[] distance : distances) {
            System.out.println(Arrays.toString(distance));
        }

        System.out.println(Arrays.toString(distances[C]));

        int result = 0;
        for (int i : distances[C]) {
            if (i != MAX) {
                result+=i;
            }
        }
        System.out.println("result: " + result);


    }

    private static class Destination {
        private final int target;
        private final int distance;

        public Destination(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }
    }

}
