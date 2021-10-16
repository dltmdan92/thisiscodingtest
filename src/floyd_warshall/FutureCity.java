package floyd_warshall;

public class FutureCity {
    private static final int max = 100000000;

    public static void main(String[] args) {
        int mid = 5;
        int fin = 4;

        int[][] lists = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, max},
                {0, 1, 0, max,1,max},
                {0, 1, max,0, 1, 1},
                {0, 1, 1,  1, 0, 1},
                {0,max,max,1, 1, 0}
        };

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

        if (lists[1][mid] >= max || lists[mid][fin] >= max) {
            System.out.println(-1);
            return;
        }


        System.out.println(lists[1][mid] + lists[mid][fin]);
    }
}
