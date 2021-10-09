package dynamic_program;

public class FloorWork {

    /*
    a[1] = 1
    a[2] = 3
    a[3] = a[1] * 2 + a[2]
    a[4] = a[2] * 2 + a[3]
     */

    public static void main(String[] args) {
        int N = 5;

        int[] memory = new int[N + 1];

        memory[1] = 1;
        memory[2] = 3;

        int current = 3;

        while (current <= N) {
            memory[current] = memory[current - 2] * 2 + memory[current - 1];
            current++;
        }

        System.out.println(memory[N]);
    }

}
