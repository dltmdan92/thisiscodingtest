package implementation;

/**
 * 시계 문제
 *
 * 정수 N이 입력되면, 00시 00분 00초 부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수
 * ex) N에 1을 입력했을 때, 3이 하나라도 포함되는 시각의 경우의 수
 * 00시 00분 03초
 * 00시 13분 30초 등등
 *
 * 힌트!! 3이 없는 시간 총 1800 (시간당), 3이 있는 시간 총 3600개 (시간당)
 *
 * Brute Force = 모든 경우의 수를 다 따져봐야 하는 문제!!!
 * 하루는 86,400초 이므로 86,400가지 --> 시각의 1씩 증가시키면서 3이 하나라도 포함되어 있는지를 확인한다.!!!!
 */
public class Second {

    public static void main(String[] args) {

        int n = 5;

        int cnt = 0;

        for (int h = 0; h <= n; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) {
                        cnt++;
                    }
                }
            }
        }

        /*
        // 내 풀이 ㅠㅠㅠ 잘못됀 풀이
        int[] hourContainsThree = {3, 13, 23};

        // 00시 부터 시작

        // 3이 포함된 시간의 갯수
        int countOfThreeHour = 0;

        for (int threeHour : hourContainsThree) {
            if (n >= threeHour) {
                countOfThreeHour+=1;
            }
        }

        // 3이 없는 시간의 갯수
        int countOfNotThreeHour = 0;

        if (n < 3) {
            countOfNotThreeHour = n + 1;
        }
        else if (3 <= n && n < 13) {
            countOfNotThreeHour = n;
        }
        else if (13 <= n && n < 23) {
            countOfNotThreeHour = n - 1;
        }
        else if (23 < n) {
            countOfNotThreeHour = n - 2;
        }

        int cnt = countOfThreeHour * 3600 + countOfNotThreeHour * 1800;*/

        System.out.println(cnt);

    }

}
