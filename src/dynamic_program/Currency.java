package dynamic_program;

public class Currency {

    public static void main(String[] args) {
        int object = 16;

        int[] coins = {5, 8};

        int[] memory = new int[object + 1];

        for (int i = 0; i < coins[0]; i++) {
            memory[i] = -1;
        }
        for (int coin : coins) {
            memory[coin] = 1;
        }

        int current = coins[0];

        while(current <= object) {

            if (memory[current] == 0) {

                int min = Integer.MAX_VALUE;

                for (int coin:coins) {
                    int beforePoint = current - coin;
                    if (beforePoint < 1 || memory[beforePoint] < 1) continue;

                    int newCount = memory[beforePoint] + 1;
                    if (min > newCount) {
                        min = newCount;
                    }
                }

                memory[current] = (min == Integer.MAX_VALUE) ? -1 : min;
            }

            current++;
        }

        for (int i = 0; i < memory.length; i++) {
            System.out.println(i + ", " + memory[i]);
        }
        System.out.println(memory[object]);
    }

}
