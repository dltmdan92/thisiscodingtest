package dynamic_program;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class MakeMoneyV2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/dynamic_program/MakeMoneyV2.txt"));
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).peek(val -> System.out.println(val)).mapToInt(Integer::valueOf).toArray();
        int coinCount = array[0];
        int objective = array[1];

        int[] results = new int[objective + 1];
        Arrays.fill(results, 10_001);

        int[] coins = new int[coinCount];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(coins);

        for (int coin : coins) {
            for (int j = 1; j < results.length; j++) {
                if (j % coin == 0) {
                    results[j] = Math.min(results[j], j / coin);
                }
            }
        }

        for (int i = coins[0]; i < results.length - coins[coinCount - 1]; i++) {

            for (int coin : coins) {
                results[i + coin] = Math.min(results[i + coin], results[i] + 1);
            }

        }

        System.out.println(Arrays.toString(results));
        System.out.println((results[objective] == 10001) ? -1 : results[objective]);

    }

}
