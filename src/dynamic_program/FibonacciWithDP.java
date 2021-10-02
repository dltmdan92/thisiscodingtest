package dynamic_program;


import java.util.ArrayList;
import java.util.List;

/**
 * 1. 최적 부분 구조 충족! (큰 문제를 작은 문제로 나눌 수 있다.) OK
 * 2. 중복되는 부분 문제 충족! (동일한 작은 문제를 반복적으로 해결한다.) OK
 *
 * Memoization --> 한 번 계산한 결과를 메모리 공간에 메모하는 기법  ,  캐싱(Caching)이라고도 한다.
 *          같은 문제를 다시 호출하면 메모했던 결과를 가져온다.
 *
 * 다이나믹 프로그래밍은 크게 두 가지 방식이 있다.
 * 1. 탑다운 (하향식)
 * 2. 바텀업 (상향식)
 *
 * DP를 사용한 피보나치 수열의 시간복잡도는 O(N) 이다.
 */
public class FibonacciWithDP {

    public static void main(String[] args) {

        // 리스트 초기화
        long[] memory = new long[100];

        int param = 20;

        long result = fibo(memory, param);

        System.out.println(result);
    }

    private static long fibo(long[] memory, int param) {
        if (param == 1 || param == 2) {
            return 1;
        }

        // 0이 아니다 => memory에 업데이트된 적이 있다.
        if (memory[param] != 0) {
            return memory[param];
        }

        memory[param] = fibo(memory, param - 1) + fibo(memory, param - 2);

        return memory[param];
    }

}
