package bfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {

    public static void main(String[] args) {
        int startNode = 1;
        List<List<Integer>> graph = List.of(
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

        boolean[] visited = new boolean[graph.size() + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.println(node);

            List<Integer> adjacentNodes = graph.get(node);

            for (int adjacentNode : adjacentNodes) {
                if (!visited[adjacentNode]) {
                    queue.add(adjacentNode);
                    visited[adjacentNode] = true;
                }
            }
        }
    }

}
