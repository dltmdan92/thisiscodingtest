package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class SeorosoSetV2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/graph/SeorosoSet.txt"));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int nodeCount = Integer.parseInt(firstLine[0]);
        int unionCount = Integer.parseInt(firstLine[1]);

        int[] set = new int[nodeCount + 1];

        for (int i = 0; i < set.length; i++) {
            set[i] = i;
        }

        for (int i = 0; i < unionCount; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]);
            int node2 = Integer.parseInt(line[1]);

            int rootOfNode1 = getRoot(node1, set);
            int rootOfNode2 = getRoot(node2, set);

            System.out.println("node1 : " + node1 + ", node2 : " + node2 + ", root1 : " + rootOfNode1 + ", root2 : " + rootOfNode2);

            if (rootOfNode1 < rootOfNode2) {
                set[node2] = rootOfNode1;
            }
            else {
                set[node1] = rootOfNode2;
            }
        }

        for (int i = 1; i < set.length; i++) {
            set[i] = getRoot(i, set);
        }

        System.out.println(Arrays.toString(set));
    }

    private static int getRoot(int rootOfNode, int[] set) {
        if (set[rootOfNode] != rootOfNode) {
            set[rootOfNode] = getRoot(set[rootOfNode], set);
        }
        return set[rootOfNode];
    }

}
