package dfs;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Dfs {

    public static void main(String[] args) {
        int startNode = 1;

        List<List<Integer>> list = List.of(
                Collections.emptyList(),
                List.of(2, 3, 8),
                List.of(1, 7),
                List.of(1, 4, 5),
                List.of(3, 5),
                List.of(4, 5),
                List.of(7),
                List.of(2, 6, 8),
                List.of(1, 7)
        );

        boolean[] visited = new boolean[list.size() + 1];

        dfs(startNode, list, visited);
    }

    private static void dfs(int startNode, List<List<Integer>> list, boolean[] visited) {
        System.out.println(startNode);
        visited[startNode] = true;

        List<Integer> nodes = list.get(startNode);
        for (int node : nodes) {
            if (!visited[node]) {
                dfs(node, list, visited);
            }
        }
    }

}
