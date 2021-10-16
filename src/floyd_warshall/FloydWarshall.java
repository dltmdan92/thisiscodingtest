package floyd_warshall;

/**
 * 플로이도 워셜 알고리즘
 * O(n^3) 의 시간 복잡도를 갖는다.
 * 모든 노드에서 모든 노드에 대한 최단 거리를 구한다.
 * (다익스트라 는 하나의 노드에서 모든 노드에 대한 최단 거리를 구한다.)
 */
public class FloydWarshall {

    // 2100000000 (INT의 MAX_VALUE) 로 할 경우 overflow 발생해서 이상한 결과 나옴;;
    private static final int max = 100000000;

    public static void main(String[] args) {

        // STEP 0
        int[][] lists = {
                {0, 0, 0, 0, 0},
                {0, 0, 4, max, 6},
                {0, 3, 0, 7, max},
                {0, 5, max, 0, 4},
                {0, max, max, 2, 0}
        };

        // STEP 1
        int now = 1;
        int nodeCount = lists.length - 1;

        while (now <= nodeCount) {
            for (int i = 1; i <= nodeCount; i++) {
                for (int j = 1; j <= nodeCount; j++) {
                    int min = Math.min(lists[i][j], lists[i][now] + lists[now][j]);
                    lists[i][j] = min;
                }
            }

            now++;
        }

        for (int[] list:lists) {
            for (int element:
                 list) {
                System.out.print(" " + element);
            }
            System.out.println();
        }
    }

}
