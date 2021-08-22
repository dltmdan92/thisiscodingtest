package dynamic_program;

/**
 * 단순 피보나치 수열 (DP 미사용)
 *
 * 단순 재귀함수로 피보나치 수열을 해결하면 지수 시간 복잡도를 가지게 된다.
 * f(6)을 호출하는데 f(2)가 5번 실행되어야 한다!!!
 * 중복되는 문제가 존재한다.
 *
 * 빅오 표기접 O(2^n)이 된다 --> 매우 치명적
 *
 * */
public class FibanacciWithoutDP {

    public static void main(String[] args) {
        // i 번째 피보나치 수를 호출한다.
        int result = fibonacci(4);
        System.out.println(result);
    }

    private static int fibonacci(int i) {
        // 재귀함수에서는 무한 루프를 막기 위해 종료 조건 명시하는것 가장 중요!!
        if (i == 1 || i == 2) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

}
