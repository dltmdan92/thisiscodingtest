package implementation;

/**
 * 구현 문제(시뮬레이션)는 모든 이동의 경로를 시뮬레이션 해봐야 한다.
 * 즉, 모든 이동의 경로 case들을 정리해야 함 --> 행렬 vector 형태로 저장하면 구조적으로 사용 가능 하다.
 *
 * n * n의 행렬
 * (1,1) 부터 (n,n) 까지
 * L R U D 좌 우 상 하 로 이동
 * 범위를 넘어가는 이동은 그냥 무시
 */
public class First {

    public static void main(String[] args) {
        int n = 5;

        int x = 1;
        int y = 1;

        String s = "RRRUDD";
        s = s.replaceAll("L", "0")
                .replaceAll("R", "1")
                .replaceAll("U", "2")
                .replaceAll("D", "3");

        String[] split = s.split("");

        // 0, 1, 2, 3
        // L, R, U, D
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < split.length; i++) {
            Integer cmd = Integer.valueOf(split[i]);
            int nx = x + dx[cmd];
            int ny = y + dy[cmd];
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                x = nx;
                y = ny;
            }
        }
        /* 매우 비효율;;;
        for (int i = 0; i < split.length; i++) {
            switch (split[i]) {
                case "L":
                    // x -1
                    if (x <= 1) {
                        break;
                    } else {
                        x -= 1;
                    }
                    break;
                case "R":
                    // x +1
                    if (x >= n) {
                        break;
                    } else {
                        x += 1;
                    }
                    break;
                case "U":
                    // y -1
                    if (y <= 1) {
                        break;
                    } else {
                        y -= 1;
                    }
                    break;
                case "D":
                    // y +1
                    if (y >= n) {
                        break;
                    } else {
                        y += 1;
                    }
                    break;
                default: break;
            }
        }*/
        System.out.println(x + " " + y);
    }

}
