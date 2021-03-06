package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1,1 부터 시작 해서 N,M(탈출구)까지 도달하는 최단거리를 구하라!!
 *
 * 0은 괴물이 있는 곳이며 피해야함
 * 1은 괴물이 없는 곳
 *
 * BFS를 수행하여 모든 노드의 최단 거리 값을 기록하면 해결할 수 있다.
 */
public class 미로탈출문제 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static int row;
    private static int col;
    // 상 하 좌 우 (순서대로)
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {

        int result = getResult(3, 3,
                        "110\n" +
                        "010\n" +
                        "011");
        System.out.println(result);
    }

    private static int getResult(int row, int col, String s) {
        // STEP 1, 노드들의 그래프 제작
        graph = makeGraph(s);
        미로탈출문제.row = row;
        미로탈출문제.col = col;

        // STEP 2, BFS 수행
        doBfs(1,1, 1);

        return graph.get(row - 1).get(col - 1);
    }

    private static void doBfs(int i, int j, int value) {
        System.out.println(graph);
        Integer nowNode = graph.get(i).get(j);

        // 현재 노드의 값에 순번을 멕여준다.
        graph.get(i).set(j ,value);
        // 그리고 큐에 순번 넣어줌
        queue.add(value);

        while (!queue.isEmpty()) {
            // queue에서 방금 빼낸 노드
            Integer pollNode = queue.poll();
            System.out.println("i : " + i + ", j : " + j);
            // element를 중심으로 상,하,좌,우 visit

            for (int d = 0; d < 4; d++) {
                // y축
                int ny = i + dy[d];
                // x축
                int nx = j + dx[d];
                // 0 = 괴물이 있는 경우 무시
                // 행,렬이 모두 범위 내에 있어야 한다.
                if (nx >= 0 && nx < col && ny >= 0 && ny < row) {
                    // 0 = 괴물이 있다! skip
                    if (graph.get(ny).get(nx) == 0) {
                        continue;
                    }
                    // 1보다 큼 = 이미 방문 했다!! SKIP
                    if (graph.get(ny).get(nx) > 1) {
                        continue;
                    }
                    // 1 = 첫 방문 일때만 수행한다.
                    if (graph.get(ny).get(nx) == 1) {
                        doBfs(ny, nx, pollNode + 1);
                    }
                }
            }
        }
    }

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
