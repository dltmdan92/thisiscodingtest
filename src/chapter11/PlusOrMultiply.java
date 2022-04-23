package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class PlusOrMultiply {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/chapter11/PlusOrMultiplyParam.txt"));
        // 0, 1은 더하기, 2 이상은 곱하기

        int[] nums = Arrays.stream(bufferedReader.readLine().split(""))
                //.map(Integer::parseInt)
                //.sorted(Comparator.reverseOrder())
                .mapToInt(Integer::valueOf)
                .toArray();

        int current = 0;

        for (int num : nums) {
            if (current == 0) {
                current = num;
            } else {
                if (num == 0 || num == 1) {
                    current += num;
                } else {
                    current *= num;
                }
            }
        }

        System.out.println(current);
    }

}
