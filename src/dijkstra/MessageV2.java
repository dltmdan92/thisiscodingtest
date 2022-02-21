package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MessageV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/dijkstra/Message.txt"));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int nodeCount = Integer.parseInt(firstLine[0]);
        int lineCount = Integer.parseInt(firstLine[1]);
        int startNode = Integer.parseInt(firstLine[2]);

        List<List<Node>> map = new ArrayList<>();
        int[] costs = new int[nodeCount + 1];
        boolean[] visited = new boolean[nodeCount + 1];

        for (int i = 0; i < nodeCount + 1; i++) {
            map.add(new ArrayList<>());
            costs[i] = 100_000_000;
        }

        for (int i = 0; i < lineCount; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int startPoint = line[0];
            int destPoint = line[1];
            int cost = line[2];
            map.get(startPoint).add(new Node(destPoint, cost));

            if (startNode == startPoint) {
                costs[destPoint] = cost;
            }
        }

        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        queue.add(new Node(startNode, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<Node> nodes = map.get(node.getVisitNode());
            visited[node.getVisitNode()] = true;

            for (Node targetNode : nodes) {
                int visitNode = targetNode.getVisitNode();
                int cost = targetNode.getCost();

                costs[visitNode] = Math.min(costs[visitNode], costs[node.getVisitNode()] + cost);
                if (!visited[visitNode])
                    queue.add(new Node(visitNode, cost));
            }

        }

        int visitedCities = 0;
        int maxUsedTime = 0;

        for (int cost : costs) {
            if (cost < 100_000_000) {
                visitedCities++;
                maxUsedTime = Math.max(cost, maxUsedTime);
            }
        }

        System.out.println(visitedCities + " " + maxUsedTime);

    }

    private static class Node {
        private final int visitNode;
        private final int cost;

        public Node(int endNode, int cost) {
            this.visitNode = endNode;
            this.cost = cost;
        }

        public int getVisitNode() {
            return visitNode;
        }

        public int getCost() {
            return cost;
        }
    }

}
