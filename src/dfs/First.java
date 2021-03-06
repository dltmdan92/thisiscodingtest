package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        List<Integer> list0 = new ArrayList<>();
        graph.add(list0);

        // 1번 노드는 2,3,8 노드와 인접
        List<Integer> list1 = new ArrayList<>();
        list1.add(2); list1.add(3); list1.add(8);
        graph.add(list1);
        // 2번 노드는 1,7 노드와 인접
        List<Integer> list2 = new ArrayList<>();
        list2.add(1); list2.add(7);
        graph.add(list2);
        // 3번 노드는 1,4,5 노드와 인접
        List<Integer> list3 = new ArrayList<>();
        list3.add(1); list3.add(4); list3.add(5);
        graph.add(list3);
        // 4번 노드는 3,5 노드와 인접
        List<Integer> list4 = new ArrayList<>();
        list4.add(3); list4.add(5);
        graph.add(list4);
        // 5번 노드는 3,4 노드와 인접
        List<Integer> list5 = new ArrayList<>();
        list5.add(3); list5.add(4);
        graph.add(list5);
        // 6번 노드는 7 노드와 인접
        List<Integer> list6 = new ArrayList<>();
        list6.add(7);
        graph.add(list6);
        // 7번 노드는 2,6,8 노드와 인접
        List<Integer> list7 = new ArrayList<>();
        list7.add(2); list7.add(6); list7.add(8);
        graph.add(list7);
        // 8번 노드는 1,7 노드와 인접
        List<Integer> list8 = new ArrayList<>();
        list8.add(1); list8.add(7);
        graph.add(list8);


        // 정의된 DFS 함수 호출
        dfs(1);
    }

    private static void dfs(int i) {
        visited[i] = true;
        List<Integer> nodes = graph.get(i);
        System.out.println(nodes);
        System.out.println(i+"방문");
        for (int j = 0; j < nodes.size(); j++) {
            int node = nodes.get(j);
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

}
