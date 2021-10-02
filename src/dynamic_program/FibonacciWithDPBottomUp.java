package dynamic_program;

public class FibonacciWithDPBottomUp {

    public static void main(String[] args) {

        int[] memory = new int[100];

        int param = 20;

        int result = fibo(memory, param);

        System.out.println(result);
    }

    private static int fibo(int[] memory, int param) {

        memory[1] = 1;
        memory[2] = 1;

        int num = 3;

        while (num <= param) {
            memory[num] = memory[num - 1] + memory[num - 2];
            num++;
        }

        return memory[param];
    }

}
