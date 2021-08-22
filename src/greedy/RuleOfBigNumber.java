package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Chapter 3. part 2 큰 수의 법칙
 *
 * 결국 가장 큰 수, 그 다음에 큰 수 만 구하면 된다.
 */
public class RuleOfBigNumber {

    public static void main(String[] args) {
        String firstLine = "5 8 3";
        String secondLine = "2 4 5 4 6";

        run(firstLine, secondLine);
    }

    private static void run(String firstLine, String secondLine) {
        String[] metas = firstLine.split(" ");
        String[] datas = secondLine.split(" ");

        int total = Integer.parseInt(metas[1]);
        int limit = Integer.parseInt(metas[2]);

        int[] maxTwoNumbers = Arrays.stream(datas)
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxNumber = maxTwoNumbers[0];
        int secondMaxNumber = maxTwoNumbers[1];

        int cycleCount = limit + 1;
        int div = total / cycleCount;
        int mod = total % cycleCount;

        int cycleSum = maxNumber * limit + secondMaxNumber;

        int result = div * cycleSum + mod * maxNumber;

        System.out.println(result);
    }

}
