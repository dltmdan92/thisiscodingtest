package dynamic_program;

public class MakeOneV2 {

    public static void main(String[] args) {
        int param = 26;

        int[] results = new int[param + 1];

        for (int i = 2; i <= param; i++) {

            results[i] = results[i - 1] + 1;

            if (i % 5 == 0) {
                results[i] = Math.min(results[i / 5] + 1, results[i]);
            } else if (i % 3 == 0) {
                results[i] = Math.min(results[i / 3] + 1, results[i]);
            } else if (i % 2 == 0) {
                results[i] = Math.min(results[i / 2] + 1, results[i]);
            }

        }

        System.out.println(results[param]);
    }

}
