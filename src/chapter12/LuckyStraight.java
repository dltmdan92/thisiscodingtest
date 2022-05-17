package chapter12;

import java.util.Arrays;

public class LuckyStraight {
    public static void main(String[] args) {
        String param = "123402";

        int divide = param.length() / 2;

        int startIndex = 0;
        int midIndex = startIndex + divide;
        int endIndex = param.length() - 1;

        String first = param.substring(startIndex, midIndex);
        String second = param.substring(midIndex, endIndex + 1);

        int firstSum = sum(first);
        int secondSum = sum(second);
        System.out.println((firstSum == secondSum) ? "LUCKY" : "READY");
    }

    private static int sum(String first) {
        return Arrays.stream(first.split(""))
                .mapToInt(Integer::valueOf)
                .reduce(0, Integer::sum);
    }
}
