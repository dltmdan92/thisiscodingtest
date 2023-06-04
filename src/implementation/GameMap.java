package implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GameMap {

    public static void main(String[] args) throws IOException {

        String param = """
                4 4
                2 2 0
                1 1 1 1
                1 0 0 1
                1 1 0 1
                1 1 1 1
                """;

        List<int[]> lines = param.lines()
                .map(line -> Arrays.stream(line.split(" ")).mapToInt((Integer::parseInt)).toArray())
                .toList();

        int[] firstLine = lines.get(0);
        int rows = firstLine[0];
        int cols = firstLine[1];

        int[] startPointAndDirection = lines.get(1);
        int currentRow = startPointAndDirection[0];
        int currentCol = startPointAndDirection[1];
        // 0 북, 1 동, 2 남, 3 서
        int currentDirection = startPointAndDirection[2];

        int[][] map = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] mapLine = lines.get(i + 2);
            for (int j = 0; j < cols; j++) {
                map[i][j] = mapLine[j];
            }
        }

        for (int[] mapLine : map) {
            System.out.println(Arrays.toString(mapLine));
        }
        int visitCount = 1;
        map[currentRow][currentCol] = 1;

        while (true) {
            System.out.println("map");
            for (int[] mapLine : map) {
                System.out.println(Arrays.toString(mapLine));
            }
            if (fourAllNotMovable(currentRow, currentCol, map)) {
                System.out.printf("fourAllNotMovable - currentRow : %d, currentCol : %d, currentDirection : %d\n", currentRow, currentCol, currentDirection);
                break;
            }

            if (movable(currentRow, currentCol, currentDirection, map)) {
                System.out.printf("currentRow : %d, currentCol : %d, currentDirection : %d\n", currentRow, currentCol, currentDirection);
                Node movedPosition = move(currentRow, currentCol, currentDirection);
                map[currentRow][currentCol] = 1;
                currentRow = movedPosition.getRow();
                currentCol = movedPosition.getCol();
                currentDirection = movedPosition.getDirection();
                System.out.printf("afterRow : %d, afterCol : %d, afterDirection : %d\n", currentRow, currentCol, currentDirection);
                visitCount++;
            } else {
                currentDirection = turnleft(currentDirection);
            }
        }
        System.out.println(visitCount);
    }

    private static boolean fourAllNotMovable(int currentRow, int currentCol, int[][] map) {
        return !fourAllMovable(currentRow, currentCol, map);
    }

    private static boolean fourAllMovable(int currentRow, int currentCol, int[][] map) {
        boolean movable = false;
        for (int direction = 0; direction <= 3; direction++) {
            movable = movable(currentRow, currentCol, direction, map);
            if (movable) {
                break;
            }
        }
        return movable;
    }

    private static boolean movable(int currentRow, int currentCol, int currentDirection, int[][] map) {
        Node movedPosition = move(currentRow, currentCol, currentDirection);

        System.out.printf("moved row: %d, moved col: %d, new direction: %d, map value: %d\n", movedPosition.getRow(), movedPosition.getCol(), movedPosition.getDirection(), map[movedPosition.getRow()][movedPosition.getCol()]);

        if (movedPosition.getRow() >= 0 && movedPosition.getRow() <= map.length - 1 && movedPosition.getCol() >= 0 && movedPosition.getCol() <= map[0].length - 1) {
            return map[movedPosition.getRow()][movedPosition.getCol()] != 1;
        } else {
            return false;
        }
    }

    private static Node move(int currentRow, int currentCol, int currentDirection) {
        int newDirection = turnleft(currentDirection);
        return switch (newDirection) {
            case 0 -> new Node(currentRow - 1, currentCol, newDirection);
            case 1 -> new Node(currentRow, currentCol + 1, newDirection);
            case 2 -> new Node(currentRow + 1, currentCol, newDirection);
            case 3 -> new Node(currentRow, currentCol - 1, newDirection);
            default -> null;
        };
    }

    private static int turnleft(int currentDirection) {
        if (currentDirection == 0) {
            return 3;
        }
        return currentDirection - 1;
    }

    public static class Node {
        private final int row;
        private final int col;
        private final int direction;

        public Node(int row, int col, int direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getDirection() {
            return direction;
        }
    }


}
