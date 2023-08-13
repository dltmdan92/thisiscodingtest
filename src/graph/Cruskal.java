package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Cruskal {

    public static void main(String[] args) {

        int nodeCount = 7;
        String param = """
                1 2 29
                1 5 75
                2 3 35
                2 6 34
                3 4 7
                4 6 23
                4 7 13
                5 6 53
                6 7 25
                """;

        int result = 0;
        int[] parentOfIndex = new int[nodeCount + 1];
        for (int i = 0; i < parentOfIndex.length; i++) {
            parentOfIndex[i] = i;
        }

        List<Edge> map = param.lines()
                .map(str -> Arrays.stream(str.split(" "))
                        .map(Integer::parseInt)
                        .toList())
                .map(list -> new Edge(list.get(0), list.get(1), list.get(2)))
                .sorted(Comparator.comparing(edge -> edge))
                .toList();

        for (Edge edge : map) {
            int rootA = getRootParent(edge.getA(), parentOfIndex);
            int rootB = getRootParent(edge.getB(), parentOfIndex);
            System.out.printf("A: %d, B: %d, rootA: %d, rootB: %d\n", edge.getA(), edge.getB(), rootA, rootB);
            if (rootA != rootB) {
                result+=edge.getDistance();
                System.out.printf("result: %d\n", result);

                int parentOfTwo = Math.min(rootA, rootB);
                int rootParent = getRootParent(parentOfTwo, parentOfIndex);
                parentOfIndex[rootA] = rootParent;
                parentOfIndex[rootB] = rootParent;
            }
        }

        for (int i = 1; i < parentOfIndex.length; i++) {

            System.out.println("i: " + i + ", parent: " + getRootParent(i, parentOfIndex));
        }

        System.out.println("result: " + result);
    }

    private static int getRootParent(int child, int[] parentOfIndex) {
        if (child == parentOfIndex[child]) {
            return child;
        }

        return getRootParent(parentOfIndex[child], parentOfIndex);
    }

    private static class Edge implements Comparable<Edge> {
        private final int a;
        private final int b;
        private final int distance;

        public Edge(int a, int b, int distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Edge target) {
            if (this.distance < target.distance) {
                return -1;
            } else if (this.distance > target.distance) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "a=" + a +
                    ", b=" + b +
                    ", distance=" + distance +
                    '}';
        }
    }

}
