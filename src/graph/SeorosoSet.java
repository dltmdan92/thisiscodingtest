package graph;

/**
 * 서로소 집합 알고리즘
 * P.273 (CHAPTER 10)
 */
public class SeorosoSet {

    public static void main(String[] args) {
        // 노드의 개수
        int v = 6;
        // 간선의 개수
        int e = 4;
        // 부모 테이블 초기화
        int[] parent = new int[v + 1];

        // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        // union 연산을 각각 수행
        // 이 부분은 생략
    }

    // 특정 원소가 속한 집합의 루트 노드를 찾기
    private int findParent(int[] parent, int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (parent[x] != x)
            //return findParent(parent, parent[x]); // find 할때마다 O(V)
            parent[x] = findParent(parent, parent[x]); // parent를 갱신 해줌으로써 O(1)
        return parent[x];
    }

    // 두 원소가 속한 집합을 합치기
    private void unionParent(int[] parent, int a, int b) {
        int node_a = findParent(parent, a);
        int node_b = findParent(parent, b);
        if (node_a < node_b)
            parent[b] = node_a;
        else
            parent[a] = node_b;
    }

}
