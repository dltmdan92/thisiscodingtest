package chapter12;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StringReSort {
    public static void main(String[] args) {
        //String param = "K1KA5CB7";
        String param = "AJKDLSI412K4JSJ9D";
        char[] chars = param.toCharArray();

        PriorityQueue<String> strings = new PriorityQueue<>(Comparator.naturalOrder());
        int sumOfNums = 0;

        for (char key : chars) {
            if (isNumber(key)) {
                sumOfNums += Integer.parseInt(String.valueOf(key));
            }
            if (isUppercase(key)) {
                strings.add(String.valueOf(key));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!strings.isEmpty()) {
            sb.append(strings.poll());
        }
        sb.append(sumOfNums);
        System.out.println(sb);
    }

    private static boolean isUppercase(char key) {
        return key >= 65 && key <= 90;
    }

    private static boolean isNumber(char key) {
        return key >= 48 && key <= 57;
    }

}
