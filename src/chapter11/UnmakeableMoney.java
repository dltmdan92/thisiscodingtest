package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class UnmakeableMoney {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/chapter11/UnmakeableMoneyParam.txt"));
        int coinCount = Integer.parseInt(bufferedReader.readLine());
        int[] coins = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        int target = 1;

        for (int coin : coins) {
            if (coin > target) {
                break;
            }
            target += coin;
        }
        System.out.println(target);
    }

}
