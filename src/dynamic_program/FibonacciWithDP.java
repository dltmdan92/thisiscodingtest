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
        int n = 7;

        // 메모이제이션을 위한 리스트 초기화
        List<Integer> dpTable = new ArrayList<>(n + 1);

        for(int i = 1; i <= n + 1; i++) {
            dpTable.add(0);
        }

        int topdownFiboresult = topdownFibo(dpTable, n);
        System.out.println("topdownFibo : " + topdownFiboresult);

        int bottomupFiboResult = bottomupFibo(dpTable, n);
        System.out.println("bottomupFibo : " + bottomupFiboResult);
    }

    /**
     * DP 의 탑다운 (하향식) 방식으로 수행
     * 재귀함수를 주로 사용한다.
     * @param dpTable
     * @param n
     * @return
     */
    private static int topdownFibo(List<Integer> dpTable, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        // 캐싱이 안된 경우
        if (dpTable.get(n) == 0) {
            int nowValue = topdownFibo(dpTable, n - 1) + topdownFibo(dpTable,n - 2);
            // 캐싱 시키고
            dpTable.set(n, nowValue);
        }
        // 캐싱 된 것을 리턴한다.
        return dpTable.get(n);
    }

    /**
     * DP 의 바텀업 (상향식) 방식으로 수행
     * 반복문을 주로 사용한다.
     * @param dpTable
     * @param n
     * @return
     */
    private static int bottomupFibo(List<Integer> dpTable, int n) {
        // 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
        dpTable.set(1, 1);
        dpTable.set(2, 1);

        // 밑에서 부터 쭉 캐싱 작업 한다.
        for (int i = 3; i <= n; i++) {
            // 캐싱 안되 있을 때
            if (dpTable.get(i) == 0) {
                int nowValue = dpTable.get(i - 1) + dpTable.get(i - 2);
                dpTable.set(i, nowValue);
            }
        }

        return dpTable.get(n);
    }

}
