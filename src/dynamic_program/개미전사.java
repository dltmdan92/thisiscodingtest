package dynamic_program;

public class 개미전사 {

    public static void main(String[] args) {
        int n = 4;
        String foods = "1 3 1 5";
        String[] s = foods.split(" ");
        // 식량창고들
        int[] array = new int[4];

        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }

        // DP용 캐싱 그릇
        int[] dpTable = new int[100];

        // 다이나믹 프로그래밍 바텀업 방식으로 진행
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dpTable[i] = array[0];
            }
            else if (i == 1) {
                dpTable[i] = Math.max(array[1], array[0]);
            }
            else {
                // 둘중에 더 큰 값이 i번째까지의 결과 값으로 등록된다.
                // i-1번째까지의 결과 vs i-2번째까지의 결과 + i번째 값
                dpTable[i] = Math.max(dpTable[i-1], dpTable[i-2]+array[i]);
            }
        }
        System.out.println(dpTable[n - 1]);
    }

}
