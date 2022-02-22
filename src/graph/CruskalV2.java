package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CruskalV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/graph/Cruskal.txt"));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int nodeCount = Integer.parseInt(firstLine[0]);
        int lineCount = Integer.parseInt(firstLine[1]);

        PriorityQueue<Line> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Line::getCost));
        int[] roots = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            roots[i] = i;
        }

        for (int i = 0; i < lineCount; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]);
            int node2 = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            priorityQueue.add(new Line(node1, node2, cost));
        }

        int total = 0;

        while (!priorityQueue.isEmpty()) {
            Line line = priorityQueue.poll();

            int start = line.getStart();
            int end = line.getEnd();
            int cost = line.getCost();

            int rootOfStart = getRoot(start, roots);
            int rootOfEnd = getRoot(end, roots);

            if (rootOfStart == rootOfEnd)
                continue;

            if (rootOfStart < rootOfEnd) {
                roots[rootOfEnd] = rootOfStart;
            } else {
                roots[rootOfStart] = rootOfEnd;
            }
            total+=cost;
        }

        System.out.println(Arrays.toString(roots));
        System.out.println(total);

    }

    private static int getRoot(int node, int[] roots) {
        if (roots[node] != node) {
            return getRoot(roots[node], roots);
        }
        return roots[node];
    }

    private static class Line {
        private final int start;
        private final int end;
        private final int cost;

        public Line(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getCost() {
            return cost;
        }
    }

}
