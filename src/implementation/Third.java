package implementation;

/**
 * 나이트 의 이동 (L자 이동 8*8)
 * 1,a 부터 8,h까지 범위
 *
 * 나이트가 이동할 수 있는 경우의 수
 *
 */
public class Third {

    public static void main(String[] args) {

        // 현재 나이트의 위치 (열, 행)
        String s = "h8";

        String[] split = s.split("");

        int cnt = 0;

        String yStr = split[0];
        String xStr = split[1];

        int y = 0;
        int x = Integer.valueOf(xStr);

        switch (yStr) {
            case "a":
                y = 1;
                break;
            case "b":
                y = 2;
                break;
            case "c":
                y = 3;
                break;
            case "d":
                y = 4;
                break;
            case "e":
                y = 5;
                break;
            case "f":
                y = 6;
                break;
            case "g":
                y = 7;
                break;
            case "h":
                y = 8;
                break;
        }

        // 움직일 수 있는 벡터 행렬 x,y
        int[] dx = {-2, 2, -2, 2, -1, 1, -1, 1};
        int[] dy = {-1, -1, 1, 1, -2, -2, 2, 2};

        for (int i = 0; i < 8; i++) {
            if (x + dx[i] >= 1 && x + dx[i] <= 8 && y + dy[i] >= 1 && y + dy[i] <= 8) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
