package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CycleCheck {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/graph/CycleCheck.txt"));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int nodeCount = Integer.parseInt(firstLine[0]);
        int lineCount = Integer.parseInt(firstLine[1]);

        int[] roots = new int[nodeCount + 1];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }

        for (int i = 0; i < lineCount; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]);
            int node2 = Integer.parseInt(line[1]);

            int rootOfNode1 = getRoot(node1, roots);
            int rootOfNode2 = getRoot(node2, roots);

            if (rootOfNode1 < rootOfNode2) {
                roots[node2] = rootOfNode1;
            }
            else if (rootOfNode1 > rootOfNode2) {
                roots[node1] = rootOfNode2;
            }
            else {
                System.out.println("사이클이 발생했습니다.");
            }
        }

    }

    private static int getRoot(int node, int[] roots) {
        if (roots[node] != node)
            return getRoot(roots[node], roots);
        return roots[node];
    }

}
