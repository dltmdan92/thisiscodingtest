package graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Cruskal {
    public static void main(String[] args) {
        String input = "7 9\n" +
                "1 2 29\n" +
                "1 5 75\n" +
                "2 3 35\n" +
                "2 6 34\n" +
                "3 4 7\n" +
                "4 6 23\n" +
                "4 7 13\n" +
                "5 6 53\n" +
                "6 7 25";

        String[] split = input.split("\n");
        String[] split1 = split[0].split(" ");
        int nodeCount = Integer.parseInt(split1[0]);

        int[] parent = new int[nodeCount + 1];

        PriorityQueue<Line> lines = new PriorityQueue<>(Comparator.comparing(Line::getCost));
        int result = 0;

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < split.length; i++) {
            String[] strings = split[i].split(" ");
            int start = Integer.parseInt(strings[0]);
            int destination = Integer.parseInt(strings[1]);
            int cost = Integer.parseInt(strings[2]);

            lines.add(new Line(start, destination, cost));
        }

        while (!lines.isEmpty()) {
            Line line = lines.poll();

            result += union(line, parent);
        }

        System.out.println(result);

    }

    public static int union(Line line, int[] parents) {
        int i = parents[line.getStart()];
        int j = parents[line.getDestination()];

        if (i == j)
            return 0;

        int rootOjI = findParent(i, parents);
        int rootOjJ = findParent(j, parents);

        if (rootOjI > rootOjJ) {
            parents[rootOjI] = rootOjJ;
        }
        else {
            parents[rootOjJ] = rootOjI;
        }

        return line.getCost();
    }

    private static int findParent(int i, int[] parents) {
        if (parents[i] != i) {
            parents[i] = findParent(parents[i], parents);
        }
        return parents[i];
    }

}

class Line {
    private int start;
    private int destination;
    private int cost;

    public Line(int start, int destination, int cost) {
        this.start = start;
        this.destination = destination;
        this.cost = cost;
    }

    public int getStart() {
        return start;
    }

    public int getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }
}
