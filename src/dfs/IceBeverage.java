package dfs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IceBeverage {
    // 상 하 좌 우
    private static final int[] drow = new int[] {-1,1,0,0};
    private static final int[] dcol = new int[] {0,0,-1,1};
    private static int rowLength;
    private static int colLength;


    public static void main(String[] args) {
        String param = """
                001
                010
                101
                """;

        List<List<Integer>> map = param.lines()
                .map(line -> Arrays.stream(line.split(""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .toList();

        rowLength = map.size();
        colLength = map.get(0).size();

        int count = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (map.get(i).get(j) == 0) {
                    DFS(map, i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void DFS(List<List<Integer>> map, int row, int col) {
        for (int i = 0; i < drow.length; i++) {
            int newRow = row + drow[i];
            int newCol = col + dcol[i];

            if (newRow >= 0 && newRow < rowLength && newCol >= 0 && newCol < colLength && map.get(newRow).get(newCol) == 0) {
                map.get(newRow).set(newCol, 1);
                DFS(map, newRow, newCol);
            }
        }
    }

    public static class Node {
        private final int row;
        private final int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
