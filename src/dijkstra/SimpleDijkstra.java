package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleDijkstra {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int nodeCount = 6;
        int lineCount = 11;
        int start = 1;
        List<List<Node>> list = new ArrayList<>(nodeCount + 1);
        for (int i = 0; i < nodeCount + 1; i++) {
            list.add(i, new ArrayList<>());
        }
        boolean[] visited = new boolean[nodeCount + 1];
        int[] distances = new int[nodeCount + 1];
        Arrays.fill(distances, INF);

        String lineString = ParamsKt.SimpleDijkstraLines();
        String[] linesString = lineString.split("\n");

        Arrays.stream(linesString)
                .forEach(line -> {
                    String[] strings = line.split(" ");
                    int aNode = Integer.parseInt(strings[0]);
                    int bNode = Integer.parseInt(strings[1]);
                    int cost = Integer.parseInt(strings[2]);

                    list.get(aNode).add(new Node(bNode, cost));
                });

        dijkstra(start, visited, distances, list);

        for (int i = 1; i < nodeCount + 1; i++) {
            if (distances[i] == INF) {
                System.out.println("INFINITY");
            }
            else {
                System.out.println(distances[i]);
            }
        }
    }

    private static void dijkstra(int start, boolean[] visited, int[] distances, List<List<Node>> list) {
        distances[start] = 0;
        visited[start] = true;

        for (Node node:list.get(start)) {
            distances[node.getTarget()] = node.getCost();
        }

        for (int i = 0; i < distances.length; i++) {
            int now = getSmallestNode(visited, distances);
            visited[now] = true;

            for (Node node:list.get(now)) {
                int cost = distances[now] + node.getCost();
                if (cost < distances[node.getTarget()]) {
                    distances[node.getTarget()] = cost;
                }
            }
        }
    }

    private static int getSmallestNode(boolean[] visited, int[] distances) {
        int minValue = INF;
        int index = 0;

        for (int i = 1; i < distances.length; i++) {
            if (distances[i] < minValue && !visited[i]) {
                minValue = distances[i];
                index = i;
            }
        }

        return index;
    }

}
