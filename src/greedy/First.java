package greedy;

/**
 * 500, 100. 50. 10원짜리 동전이 무한
 * N원일 때 거슬러 줘야할 동전의 최소 개수 (총 갯수)
 */
public class First {
    public static void main(String[] args) {
        int n = 1260;
        int cnt = 0;
        int[] coins = {500, 100, 50, 10};

        for(int i = 0; i < coins.length; i++) {
            // 소모된 동전 갯수
            int div = n / coins[i];
            // 남은 거스름 돈
            int mod = n % coins[i];
            // 지급한 동전 총 갯수
            cnt += div;
            // 이제 마저 지급해야 할 금액
            n = mod;
            // 모든 필요한 계산을 마치고, 이제 지급할 돈이 0원이면 break!
            if (mod == 0)
                break;
        }

        System.out.println(cnt);
    }
}
