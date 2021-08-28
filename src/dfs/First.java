package dfs;

import java.util.*;

/**
 * DFS
 * 깊이 우선 탐색, 깊은 부분을 우선적으로 탐색하는 알고리즘 이다.
 *
 * DFS는 스택 자료구조 (OR 재귀함수)를 이용,
 *
 * 1. 탐색 시작 노드를 스택에 삽입하고 방문 처리
 * 2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면, 그 노드를 스택에 넣고 방문 처리
 *      방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
 * 3. 더 이상 2번의 과정을 수행할 수 없을 때까지 반복한다.
 */
public class First {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited = new boolean[9];

    public static void main(String[] args) {
        // 각 노드가 연결된 정보를 표현 (2차원 리스트)

        graph = List.of(
                Collections.emptyList(),
                List.of(2, 3, 8),
                List.of(1, 7),
                List.of(1, 4, 5),
                List.of(3, 5),
                List.of(3, 4),
                List.of(7),
                List.of(2, 6, 8),
                List.of(1, 7)
        );

        // 정의된 DFS 함수 호출
        dfs(1);
    }

    private static void dfs(int i) {
        visited[i] = true;
        List<Integer> nodes = graph.get(i);
        System.out.println(nodes);
        System.out.println(i+"방문");
        for (int node : nodes) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

}
