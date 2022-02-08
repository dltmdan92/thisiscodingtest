package implementation;

import java.nio.charset.StandardCharsets;

public class KnightOfKingdomV2 {

    public static void main(String[] args) {
        String param = "c2";
        final int CHESS_ROW = 8;
        final int CHESS_COL = 8;

        String[] position = param.split("");
        int colPosition = position[0].getBytes(StandardCharsets.US_ASCII)[0] - 97;
        int rowPosition = Integer.parseInt(position[1]) - 1;

        int[] rowMove = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] colMove = {-1, 1, 2, -2, 2, -2, 1, -1};

        int result = 0;

        for (int i = 0; i < rowMove.length; i++) {
            int moveRow = rowMove[i];
            int moveCol = colMove[i];

            int nowRowPosition = rowPosition + moveRow;
            int nowColPosition = colPosition + moveCol;

            if ((nowRowPosition >= 0 && nowRowPosition < CHESS_ROW) && (nowColPosition >= 0 && nowColPosition < CHESS_COL)) {
                result++;
            }
        }

        System.out.println(result);
    }

}
