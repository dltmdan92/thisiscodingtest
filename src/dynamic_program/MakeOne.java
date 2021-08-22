package dynamic_program;

import java.util.PriorityQueue;

/**
 * 1로 만들기 문제
 *
 * 이거는 그리디 알고리즘에서의 1만들기와는 다르다. 단순 그리디 해법으로 해결하기 힘들다.
 * 그리디에서는 무조건 나누기를 먼저, 최대한 할려고 했음
 *
 * 여기서는 최적 부분 구조 + 중복되는 부분 문제를 가진다.
 *
 * 다이나믹 프로그래밍은 점화식으로 풀어라라 */
public class MakeOne {
    public static void main(String[] args) {
        int[] d = new int[30001];
        int x = 33;
        d[2] = 1;
        d[3] = 1;
        d[5] = 1;

        for (int i = 2; i <= x; i++) {
            d[i] = d[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i/2] + 1);
            }
            // 현재의 수가 3로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i/3] + 1);
            }
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0) {
                d[i] = Math.min(d[i], d[i/5] + 1);
            }
            System.out.println("d["+i+"] : " + d[i]);
        }

        System.out.println(d[x]);
    }


}
