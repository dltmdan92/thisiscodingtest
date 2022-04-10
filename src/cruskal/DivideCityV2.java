package cruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DivideCityV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/cruskal/divide_city.txt"));
        int[] firstLineElements = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        int houseCount = firstLineElements[0];
        int lineCount = firstLineElements[1];

        int[] roots = new int[houseCount + 1];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }

        PriorityQueue<Line> queue = new PriorityQueue<>(Comparator.comparingInt(Line::getCost));

        for (int i = 0; i < lineCount; i++) {
            int[] lineElements = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            int aHouse = lineElements[0];
            int bHouse = lineElements[1];
            int cost = lineElements[2];

            Line line = Line.makeLine(aHouse, bHouse, cost);
            queue.add(line);
        }

        int result = 0;
        int largestCost = 0;

        while(!queue.isEmpty()) {
            Line line = queue.poll();

            roots[line.getaHouse()] = findRoot(roots, line.getaHouse());
            roots[line.getbHouse()] = findRoot(roots, line.getbHouse());

            if (roots[line.getaHouse()] != roots[line.getbHouse()]) {
                uniteHouse(roots, line);
                result += line.getCost();
                largestCost = Math.max(largestCost, line.getCost());
            }
        }

        System.out.println(result - largestCost);
    }

    private static void uniteHouse(int[] roots, Line line) {
        if (roots[line.getaHouse()] < roots[line.getbHouse()]) {
            roots[roots[line.getbHouse()]] = roots[line.getaHouse()];
        }
        else if (roots[line.getaHouse()] > roots[line.getbHouse()]) {
            roots[roots[line.getaHouse()]] = roots[line.getbHouse()];
        }
    }

    private static int findRoot(int[] roots, int house) {
        if (roots[house] != house)
            roots[house] = findRoot(roots, roots[house]);
        return roots[house];
    }

    private static class Line {
        private final int aHouse;
        private final int bHouse;
        private final int cost;

        public static Line makeLine(int aHouse, int bHouse, int cost) {
            return new Line(aHouse, bHouse, cost);
        }

        public int getaHouse() {
            return aHouse;
        }

        public int getbHouse() {
            return bHouse;
        }

        public int getCost() {
            return cost;
        }

        private Line(int aHouse, int bHouse, int cost) {
            this.aHouse = aHouse;
            this.bHouse = bHouse;
            this.cost = cost;
        }
    }

}
