package implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UpDownLeftRight {

    public static void main(String[] args) throws IOException {
        String param = """
                5
                R R R U D D
                """;

        List<String> lines = param.lines().toList();
        int N = Integer.parseInt(lines.get(0));
        String[] LRUDs = lines.get(1).split(" ");

        Map<String, Node> moveMap = Map.of(
                "L", Node.of(0, -1),
                "R", Node.of(0, 1),
                "U", Node.of(-1, 0),
                "D", Node.of(1, 0)
        );

        Node currentNode = Node.of(0, 0);

        for (String LRUD : LRUDs) {
            currentNode.move(moveMap.get(LRUD), N);
        }

        System.out.println(currentNode);
    }

    public static class Node {
        private int row;
        private int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public static Node of(int row, int col) {
            return new Node(row, col);
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public void move(Node move, int N) {
            if (isMovable(move, N)) {
                this.row += move.getRow();
                this.col += move.getCol();
            }
        }

        private boolean isMovable(Node move, int N) {
            int newRow = this.row + move.getRow();
            int newCol = this.col + move.getCol();

            return newRow >= 0 && newRow <= N - 1 && newCol >= 0 && newCol <= N - 1;
        }

        @Override
        public String toString() {
            return String.format("%d %d", this.row+1, this.col+1);
        }
    }

}
