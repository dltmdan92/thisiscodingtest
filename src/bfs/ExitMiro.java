package bfs;

import java.util.*;
import java.util.stream.Collectors;

public class ExitMiro {
    private static int rows, cols;

    public static void main(String[] args) {
        String[] rowsAndCols = ExitMiroParamKt.firstParam().split(" ");
        rows = Integer.parseInt(rowsAndCols[0]);
        cols = Integer.parseInt(rowsAndCols[1]);

        String[] lines = ExitMiroParamKt.secondParam().split("\n");

        List<List<Integer>> data = Arrays.stream(lines)
                .map(line -> line.split(""))
                .map(line -> Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList()))
                .collect(Collectors.toList());

        int[] dRow = {1, -1, 0, 0};
        int[] dCol = {0, 0, 1, -1};

        Element firstElement = new Element(0, 0);
        Element resultElement = null;

        Queue<Element> queue = new LinkedList<>();

        queue.add(firstElement);

        while (!queue.isEmpty()) {
            Element element = queue.poll();

            int nowRow = element.getRow();
            int nowCol = element.getCol();
            int nowValue = data.get(nowRow).get(nowCol);

            // 목적지 도달 시 break
            if (isDestination(nowRow, nowCol)) {
                resultElement = element;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = nowRow + dRow[i];
                int newCol = nowCol + dCol[i];

                if(!isValidNewPosition(newRow, newCol)) continue;

                Integer newPositionVal = data.get(newRow).get(newCol);

                if (newPositionVal != 1) continue;

                // 새로 가는 곳의 값을 1씩 증가
                data.get(newRow).set(newCol, nowValue+1);

                queue.add(new Element(newRow, newCol));
            }
        }

        assert resultElement != null;
        int result = data.get(resultElement.getRow()).get(resultElement.getCol());

        System.out.println(result);
    }

    private static boolean isDestination(int nowRow, int nowCol) {
        return (nowRow == rows - 1) && (nowCol == cols - 1);
    }

    private static boolean isValidNewPosition(int newRow, int newCol) {
        return (newRow >= 0 && newRow < rows) && (newCol >= 0 && newCol < cols);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            return row == element.row && col == element.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
