package dynamic_program;

import java.util.*;

/**
 * m 원을 만들어야 하는 최소한의 화폐 개수
 *
 * 점화식으로 풀어라!!
 *
 * ㅠㅠ 다프 너무 힘듬
 */
public class 화폐만들기 {

    public static void main(String[] args) {
        // 화폐의 종류 갯수
        int n = 2;
        // 만들어야 하는 돈
        int m = 16;

        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);
        d[0] = 0;

        String moneyStr = "2 3";

        String[] moneyStrs = moneyStr.split(" ");
        // STEP 1. 역순으로 된 QUEUE 만들어 주기
        // 최소한의 화폐를 쓰기 위해서는 가장 큰 것부터 적용해야 한다. --> 내림차순 정렬
        int[] moneys = new int[moneyStrs.length];

        /**
         * 나머지는 강의 참고 ㅠㅠㅠ         */
    }

}
