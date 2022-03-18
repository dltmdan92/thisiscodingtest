package graph;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySortV2 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/graph/TopologySort.txt"));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int nodeCount = Integer.parseInt(firstLine[0]);
        int lineCount = Integer.parseInt(firstLine[1]);

        int[] entranceDegrees = new int[nodeCount + 1];
        List<List<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < nodeCount + 1; i++) {
            lines.add(new ArrayList<>());
        }

        for (int i = 0; i < lineCount; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int destination = Integer.parseInt(line[1]);
            entranceDegrees[destination]++;
            lines.get(start).add(destination);
        }

        int zeroDegreeNode = findZeroDegreeNode(entranceDegrees);
        System.out.println("zeroDegreeNode : " + zeroDegreeNode);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(zeroDegreeNode);

        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.println(node);

            List<Integer> connectedNodes = lines.get(node);
            for (int connectedNode : connectedNodes) {
                entranceDegrees[connectedNode]--;

                if (entranceDegrees[connectedNode] == 0) {
                    queue.add(connectedNode);
                }
            }
        }
    }

    private static int findZeroDegreeNode(int[] entranceDegrees) {
        int index = 0;
        for (int i = 0; i < entranceDegrees.length; i++) {
            if (entranceDegrees[i] == 0)
                index = i;
        }
        return index;
    }

}
