package dynamic_program;

public class AntWarrior {

    public static void main(String[] args) {
        int numOfWarehouse = 8;
        int[] warehouse = {0, 1, 3, 1, 5, 9, 4, 7, 6};

        int index = 3;
        int[] memory = new int[numOfWarehouse + 1];
        memory[1] = warehouse[1];
        memory[2] = warehouse[2];

        while (index <= numOfWarehouse) {
            // memory[index - 1] vs memory[index - 2] + now

            int beforeOne = memory[index - 1];
            int beforeTwoPlusNow = memory[index - 2] + warehouse[index];

            memory[index] = Math.max(beforeOne, beforeTwoPlusNow);

            index++;
        }

        System.out.println(memory[numOfWarehouse]);
    }

}
