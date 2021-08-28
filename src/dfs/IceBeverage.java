package dfs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IceBeverage {
    private static int rows, cols;

    public static void main(String[] args) {
        String firstParam = IceBeverageParamKt.getFirstParam();
        String secondParam = IceBeverageParamKt.getSecondParam();

        String[] rowsAndCols = firstParam.split(" ");
        rows = Integer.parseInt(rowsAndCols[0]);
        cols = Integer.parseInt(rowsAndCols[1]);

        String[] lines = secondParam.split("\n");
        List<List<Integer>> data = Arrays.stream(lines)
                .map(line -> {
                    String[] split = line.split("");
                    return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
                })
                .collect(Collectors.toList());

        int result = 0;

        for (int n = 0; n < rows; n++) {
            for (int m = 0; m < cols; m++) {
                if (dfs(data, n, m)) result++;
            }
        }

        System.out.println(result);
    }

    private static boolean dfs(List<List<Integer>> data, int row, int col) {

        if ((row < 0 || col < 0) ||
                (row >= rows || col >= cols)
        ) {
            return false;
        }

        if (data.get(row).get(col) == 1) {
            return false;
        }

        data.get(row).set(col, 1);

        dfs(data, row + 1, col);
        dfs(data, row, col + 1);
        dfs(data, row - 1, col);
        dfs(data, row, col - 1);

        return true;
    }
}
