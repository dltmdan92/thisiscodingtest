package dynamic_program;

public class 바닥공사 {

    public static void main(String[] args) {

        int n = 5;

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] * 2 + dp[i - 1];
        }

        System.out.println(dp[5]);

    }

}
