package implementation;

public class KnightOfKingdom {
    public static void main(String[] args) {

        String param = "a1";

        char[] startRowAndColPoint = param.toCharArray();

        char startColPointChar = startRowAndColPoint[0];
        char startRowPointChar = startRowAndColPoint[1];

        int startColPoint = startColPointChar - 'a';
        int startRowPoint = startRowPointChar - '1';

        System.out.printf("startColPoint : %d, startRowPoint : %d\n", startColPoint, startRowPoint);

        int[] moveRows = {1, -1, 1, -1, 2, -2, 2, -2};
        int[] moveCols = {2, 2, -2, -2, 1, 1, -1, -1};

        int count = 0;

        for (int i = 0; i < moveRows.length; i++) {
            int moveRow = moveRows[i];
            int moveCol = moveCols[i];

            int movedRow = startRowPoint + moveRow;
            int movedCol = startColPoint + moveCol;

            if (movedRow >= 0 && movedRow <= 7 && movedCol >= 0 && movedCol <= 7) {
                count++;
            }
        }

        System.out.println(count);
    }
}
