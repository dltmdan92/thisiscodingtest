package cruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DivideCity {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/cruskal/divide_city.txt"));

        String firstReadLine = bufferedReader.readLine();
        String[] firstLine = firstReadLine.split(" ");
        int numOfHouses = Integer.parseInt(firstLine[0]);
        int numOfLines = Integer.parseInt(firstLine[1]);

        int[] parentOfHouse = new int[numOfHouses + 1];
        for (int i = 1; i <= numOfHouses; i++) {
            parentOfHouse[i] = i;
        }

        PriorityQueue<Line> queue = new PriorityQueue<>(Comparator.comparing(Line::getCost));

        String param;
        while((param = bufferedReader.readLine()) != null) {
            String[] elements = param.split(" ");
            queue.add(new Line(elements[0], elements[1], elements[2]));
        }

        int result = 0;
        int minus = 0;

        while(!queue.isEmpty()) {
            Line line = queue.poll();
            int cost = union(line, parentOfHouse);
            result += cost;
            minus = Math.max(minus, cost);
        }

        System.out.println(result - minus);
    }

    private static int union(Line line, int[] parentOfHouse) {
        int startNode = line.getStartNode();
        int destNode = line.getDestNode();

        int rootOfStartNode = findParent(startNode, parentOfHouse);
        int rootOfDestNode = findParent(destNode, parentOfHouse);

        if (rootOfStartNode == rootOfDestNode) {
            return 0;
        }

        if (rootOfStartNode < rootOfDestNode) {
            parentOfHouse[rootOfDestNode] = rootOfStartNode;
        }
        else {
            parentOfHouse[rootOfStartNode] = rootOfDestNode;
        }

        return line.getCost();
    }

    private static int findParent(int node, int[] parentOfHouse) {
        if (node != parentOfHouse[node]) {
            parentOfHouse[node] = findParent(parentOfHouse[node], parentOfHouse);
        }
        return parentOfHouse[node];
    }

    private static class Line {
        private final int startNode;
        private final int destNode;
        private final int cost;

        public Line(String startNode, String destNode, String cost) {
            this.startNode = Integer.parseInt(startNode);
            this.destNode = Integer.parseInt(destNode);
            this.cost = Integer.parseInt(cost);
        }

        public int getStartNode() {
            return startNode;
        }

        public int getDestNode() {
            return destNode;
        }

        public int getCost() {
            return cost;
        }
    }

}
