package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SimpleDijkstraV2 {
    private static final int START_NODE_INDEX = 0;
    private static final int DESTINATION_NODE_INDEX = 1;
    private static final int COST_INDEX = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/dijkstra/SimpleDijkstra.txt"));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int nodeCount = Integer.parseInt(firstLine[0]);
        int lineCount = Integer.parseInt(firstLine[1]);

        boolean[] visitedArray = new boolean[nodeCount + 1];
        int[] costArray = new int[nodeCount + 1];

        Arrays.fill(costArray, Integer.MAX_VALUE);

        List<List<Node>> map = new ArrayList<>();
        for (int i = 0; i < nodeCount + 1; i++) {
            map.add(new ArrayList<>());
        }

        int firstStartNode = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineCount; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int startNode = line[START_NODE_INDEX];
            int destinationNode = line[DESTINATION_NODE_INDEX];
            int cost = line[COST_INDEX];
            map.get(startNode).add(new Node(destinationNode, cost));
        }


        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        queue.add(new Node(firstStartNode, 0));
        costArray[firstStartNode] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visitedArray[node.getNodeNum()] = true;

            List<Node> destionationNodes = map.get(node.getNodeNum());

            for (Node destinationNode : destionationNodes) {
                int nodeNum = destinationNode.getNodeNum();
                int cost = destinationNode.getCost();

                costArray[nodeNum] = Math.min(costArray[nodeNum], node.getCost() + cost);

                if (!visitedArray[nodeNum]) {
                    queue.add(new Node(nodeNum, costArray[nodeNum]));
                }
            }
        }

        for (int i = 1; i < costArray.length; i++) {
            int cost = costArray[i];
            System.out.println(cost);
        }

    }

    private static class Node {
        private final int nodeNum;
        private final int cost;

        public Node(int nodeNum, int cost) {
            this.nodeNum = nodeNum;
            this.cost = cost;
        }

        public int getNodeNum() {
            return nodeNum;
        }

        public int getCost() {
            return cost;
        }
    }

}
