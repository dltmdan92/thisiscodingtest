package dynamic_program;

/**
 * 1로 만들기 문제
 *
 *
 * 이거는 그리디 알고리즘에서의 1만들기와는 다르다. 단순 그리디 해법으로 해결하기 힘들다.
 * 그리디에서는 무조건 나누기를 먼저, 최대한 할려고 했음
 *
 * 여기서는 최적 부분 구조 + 중복되는 부분 문제를 가진다.
 *
 * 다이나믹 프로그래밍은 점화식으로 풀어라라 */
public class MakeOne {
    public static void main(String[] args) {
        int param = 27;
        int[] memory = new int[param + 1];

        memory[1] = 0;
        memory[2] = 1;
        memory[3] = 1;
        memory[4] = 2;
        memory[5] = 1;

        if (param <= 5) {
            System.out.println(memory[param]);
            return;
        }

        int index = 6;
        while (index <= param) {
            int divFive = Integer.MAX_VALUE;
            int divThree = Integer.MAX_VALUE;
            int divTwo = Integer.MAX_VALUE;
            int minusOne = memory[index - 1];

            if (index % 5 == 0) {
                divFive = memory[index / 5];
            }
            if (index % 3 == 0) {
                divThree = memory[index / 3];
            }
            if (index % 2 == 0) {
                divTwo = memory[index / 2];
            }

            int min = minOfFour(divFive, divThree, divTwo, minusOne);

            memory[index] = min + 1;

            index++;
        }

        System.out.println(memory[param]);

    }

    private static int minOfFour(int divFive, int divThree, int divTwo, int minusOne) {
        int min = divFive;

        if (min > divThree) min = divThree;

        if (min > divTwo) min = divTwo;

        if (min > minusOne) min = minusOne;

        return min;
    }


}
