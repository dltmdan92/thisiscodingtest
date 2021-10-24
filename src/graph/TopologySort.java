package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 위상정렬 알고리즘
 */
public class TopologySort {

    public static void main(String[] args) {
        String param = TopologySortParamKt.param();

        String[] split = param.split("\n");
        String[] split1 = split[0].split(" ");
        int nodeCount = Integer.parseInt(split1[0]);
        int lineCount = Integer.parseInt(split1[1]);

        int[] edgeCount = new int[nodeCount + 1];

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nodeCount + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < split.length; i++) {
            String[] split2 = split[i].split(" ");
            int start = Integer.parseInt(split2[0]);
            int destination = Integer.parseInt(split2[1]);
            list.get(start).add(destination);
            edgeCount[destination]++;
        }

        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                queue.add(i);
                result.add(i);
            }
        }

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();

            List<Integer> integers = list.get(poll);

            for (int i = 0; i < integers.size(); i++) {
                Integer integer = integers.get(i);
                edgeCount[integer]--;

                if (edgeCount[integer] == 0) {
                    queue.add(integer);
                    result.add(integer);
                }
            }
        }

        result.forEach(System.out::println);
    }

}
