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
        int[] parents = new int[v + 1];

        // STEP 1
        // 각각의 노드의 부모를 자기 자신으로 설정
        for (int i = 1; i < parents.length ; i++) {
            parents[i] = i;
        }

        union(1, 4, parents);
        union(2, 3, parents);
        union(2, 4, parents);
        union(5, 6, parents);

        for (int i = 1, parentsLength = parents.length; i < parentsLength; i++) {
            System.out.println(i + " : " + findRoot(i, parents));
        }

    }

    public static void union(int i, int j, int[] parents) {
        int rootOfI = findRoot(i, parents);
        int rootOfJ = findRoot(j, parents);

        if (rootOfI > rootOfJ) {
            parents[rootOfI] = rootOfJ;
        }
        else {
            parents[rootOfJ] = rootOfI;
        }
    }

    private static int findRoot(int i, int[] parents) {
        int parent = parents[i];
        if (parent == i) {
            return parent;
        }
        return findRoot(parent, parents);
    }


}
