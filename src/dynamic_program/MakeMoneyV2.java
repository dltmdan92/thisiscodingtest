package dynamic_program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MakeMoneyV2 {

    public static void main(String[] args) {

        String param = """
                3 7
                2
                3
                5
                """;

        List<String> lines = param.lines().collect(Collectors.toList());

        int[] firstLine = Arrays.stream(lines.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = firstLine[0];
        int m = firstLine[1];

        List<Integer> coins = new ArrayList<>(n);
        int[] dp = new int[10001];

        for (int i = 1; i < 1 + n; i++) {
            coins.add(Integer.parseInt(lines.get(i)));
            dp[Integer.parseInt(lines.get(i))] = 1;
        }

        Integer firstCoin = coins.get(0);

        for (int i = firstCoin; i <= m; i++) {
            if (dp[i] != 0) {
                continue;
            }

            int minResult = Integer.MAX_VALUE;

            for (Integer coin : coins) {
                if (i - coin > 0 && dp[i - coin] != 0) {
                    minResult = Math.min(minResult, dp[i - coin] + 1);
                }
            }

            if (minResult != Integer.MAX_VALUE) {
                dp[i] = minResult;
            } else {
                dp[i] = -1;
            }
        }

        if (dp[m] != 0) {
            System.out.println(dp[m]);
        } else {
            System.out.println(-1);
        }
    }

}
