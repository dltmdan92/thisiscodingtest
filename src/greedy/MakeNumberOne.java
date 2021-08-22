package greedy;

/**
 * Chapter 3. part 2 1이 될때까지
 *
 * 1이 될 때까지
 * 어떤 수 N이 1이 될 때까지 아래 두과정 중 하나를 반복
 * 1. N에서 1을 뺌
 * 2. N을 K로 나눔
 *
 * N과 K가 주어졌을 때 N이 1이 될 때까지 최소 수행해야 하는 갯수
 *
 * 힌트 주어진 N에 대하여 최대한 많이 나누기를 수행하면 된다.
 * 즉, 그리디 알고리즘은 "최적의 해" 방법이 보장되면 그걸로 밀고 가면 된다.
 */
public class MakeNumberOne {

    public static void main(String[] args) {
        int n = 25;
        int k = 5;
        int cnt = 0;

        while(n != 1) {
            if (n % k == 0) {
                n = n / k;
            }
            else {
                n = n - 1;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
