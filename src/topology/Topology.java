package topology;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Topology {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/topology/topology_param.txt"));

        String[] firstLine = bufferedReader.readLine().split(" ");
        int nodeCount = Integer.parseInt(firstLine[0]);
        int lineCount = Integer.parseInt(firstLine[1]);

        // INIT
        List<Integer> degrees = new ArrayList<>();
        for (int i = 0; i < nodeCount + 1; i++) {
            degrees.add(0);
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nodeCount + 1; i++) {
            list.add(new ArrayList<>());
        }

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] infos = line.split(" ");
            int start = Integer.parseInt(infos[0]);
            int end = Integer.parseInt(infos[1]);

            Integer currentDegree = degrees.get(end);
            degrees.set(end, currentDegree + 1);

            list.get(start).add(end);
        }

        List<Integer> startNodes = findAllNodesWithNoDegree(degrees);

        if (startNodes.isEmpty())
            return;

        Queue<Integer> queue = new LinkedList<>(startNodes);

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            result.add(node);

            List<Integer> destinations = list.get(node);
            destinations.forEach(destination -> {
                Integer currentDegree = degrees.get(destination);
                int newDegree = currentDegree - 1;
                degrees.set(destination, newDegree);

                if (newDegree == 0) {
                    queue.add(destination);
                }
            });
        }

        result.forEach(i -> System.out.println(i + " "));

    }

    private static List<Integer> findAllNodesWithNoDegree(List<Integer> degrees) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < degrees.size(); i++) {
            if (degrees.get(i) == 0)
                list.add(i);
        }
        return list;
    }
}
