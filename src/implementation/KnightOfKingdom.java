package implementation;

public class KnightOfKingdom {
    public static void main(String[] args) {

        String param = "d5";
        char[] chars = param.toCharArray();

        int startCol = chars[0];
        int startRow = chars[1] - 48;

        int firstCol = 'a';
        int lastCol = firstCol + 7;
        int firstRow = 1;
        int lastRow = firstRow + 7;

        // col, row
        int[][] steps = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

        int count = 0;

        for (int[] step : steps) {
            int colToMove = step[0];
            int rowToMove = step[1];

            int resultCol = startCol + colToMove;
            int resultRow = startRow + rowToMove;

            if (isColOk(resultCol, firstCol, lastCol) && isRowOk(resultRow, firstRow, lastRow)) count++;
        }

        System.out.println(count);
    }

    private static boolean isColOk(int resultCol, int firstCol, int lastCol) {
        return ((resultCol >= firstCol && resultCol <= lastCol));
    }

    private static boolean isRowOk(int resultRow, int firstRow, int lastRow) {
        return ((resultRow >= firstRow && resultRow <= lastRow));
    }
}
