package dfs;

import java.util.ArrayList;
import java.util.List;

public class 음료수얼려먹기 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int row;
    private static int col;
    private static int result;

    public static void main(String[] args) {
        int result = getResult(8, 6,
                    "001100\n" +
                        "000110\n" +
                        "111111\n" +
                        "001110\n" +
                        "111010\n" +
                        "011011\n" +
                        "011011\n" +
                        "110110");
        System.out.println(result);
    }

    private static int getResult(int row, int col, String s) {
        // STEP 1, 노드들의 그래프 제작
        graph = makeGraph(s);

        음료수얼려먹기.row = row;
        음료수얼려먹기.col = col;

        // DFS를 돌려보자
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                doDFS(i, j, true);
            }
        }

        return result;
    }

    // 방문하면 0을 1으로 바꾼다.
    private static void doDFS(int i, int j, boolean isFirst) {
        Integer element = graph.get(i).get(j);

        // 1이면 더이상 방문 X
        if (element == 1)
            return;

        // 방문했으니 1로 바꿈
        graph.get(i).set(j, 1);
        // 덩어리의 첫번째 방문일때만 카운트
        if (isFirst) {
            result++;
        }

        // element를 중심으로 상,하,좌,우 visit
        // 상 j는 그대로
        int upToMove = i - 1;
        // 하 j는 그대로
        int downToMove = i + 1;
        // 좌 i는 그대로
        int leftToMove = j - 1;
        // 우 i는 그래도
        int rightToMove = j + 1;

        if (upToMove >= 0)
            doDFS(upToMove, j, false);
        if (downToMove < row)
            doDFS(downToMove, j, false);
        if (leftToMove >= 0)
            doDFS(i, leftToMove, false);
        if (rightToMove < col)
            doDFS(i, rightToMove, false);
    }

    /**
     * DFS를 위한 그래프 제작
     * @param s
     * @return
     */
    private static List<List<Integer>> makeGraph(String s) {
        List<List<Integer>> graph = new ArrayList<>();
        String[] rows = s.split("\n");

        for (int i = 0; i < rows.length; i++) {
            String rowTotal = rows[i];
            String[] rowElements = rowTotal.split("");
            List<Integer> rowList = new ArrayList<>();

            for(String element: rowElements) {
                rowList.add(Integer.valueOf(element));
            }

            graph.add(rowList);
        }
        // graph 제조 완료
        System.out.println(graph);
        return graph;
    }

}
