package dijkstra;

import java.util.*;

public class AdvancedDijkstra {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(Node::getCost));

        int nodeCount = 6;
        int start = 1;
        List<List<Node>> list = new ArrayList<>(nodeCount + 1);
        for (int i = 0; i < nodeCount + 1; i++) {
            list.add(i, new ArrayList<>());
        }
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

        dijkstra(start, distances, list, priorityQueue);

        for (int i = 1; i < nodeCount + 1; i++) {
            if (distances[i] == INF) {
                System.out.println("INFINITY");
            }
            else {
                System.out.println(distances[i]);
            }
        }
    }

    private static void dijkstra(int start, int[] distances, List<List<Node>> list, PriorityQueue<Node> priorityQueue) {
        distances[start] = 0;
        priorityQueue.add(new Node(start, 0));

        while(!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();

            List<Node> nodes = list.get(now.getTarget());

            nodes.forEach(node -> {
                int newCost = distances[now.getTarget()] + node.getCost();
                if (newCost < distances[node.getTarget()]) {
                    distances[node.getTarget()] = newCost;
                    priorityQueue.add(node);
                }
            });
        }
    }

}
