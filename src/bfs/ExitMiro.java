package bfs;

import implementation.UpDownLeftRight;

import java.util.*;
import java.util.stream.Collectors;

public class ExitMiro {
    private static int rows, cols;

    private static final int[] dRow = {1, -1, 0, 0};
    private static final int[] dCol = {0, 0, 1, -1};
    private static int destinationRow;
    private static int destinationCol;

    public static void main(String[] args) {
        String firstParam = "5 6";
        String secondParam = """
                101010
                111111
                000001
                111111
                111111
                """;

        int[] destination = Arrays.stream(firstParam.split(" ")).mapToInt(Integer::parseInt).toArray();
        destinationRow = destination[0] - 1;
        destinationCol = destination[1] - 1;

        System.out.println("destinationRow : " + destinationRow);
        System.out.println("destinationCol : " + destinationCol);

        List<List<Integer>> map = secondParam.lines()
                .map(line -> Arrays.stream(line.split("")).map(Integer::parseInt).collect(Collectors.toList()))
                .toList();

        Element start = new Element(0, 0);

        Queue<Element> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            System.out.println("queue");
            Element visitedElement = queue.poll();

            for (int i = 0; i < dRow.length; i++) {
                int newRow = visitedElement.getRow() + dRow[i];
                int newCol = visitedElement.getCol() + dCol[i];
                System.out.println("newRow: " + newRow + ", newCol: " + newCol);
                System.out.println("map.size() : " + map.size());
                System.out.println("map.get(0).size() : " + map.get(0).size());
                System.out.println("(newRow != 0 && newCol != 0) : " + (newRow != 0 && newCol != 0));
                if (newRow >= 0 && newRow < map.size() && newCol >= 0 && newCol < map.get(0).size()
                        && (newRow != 0 || newCol != 0)
                        && (map.get(newRow).get(newCol) == 1)
                ) {
                    Integer nowVal = map.get(visitedElement.getRow()).get(visitedElement.getCol());
                    queue.add(new Element(newRow, newCol));
                    map.get(newRow).set(newCol, nowVal + 1);
                    System.out.println(map.get(newRow).get(newCol));
                }
                if (newRow == destinationRow && newCol == destinationCol) {
                    System.out.println("break");
                    break;
                }
            }
        }

        System.out.println(map.get(destinationRow).get(destinationCol));
    }


    private static class Element {
        private final int row;
        private final int col;

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public Element(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
