package graph;

import java.util.Arrays;
import java.util.List;

public class Seoroso {

    public static void main(String[] args) {

        String param = """
                6
                1 4
                2 3
                2 4
                5 6
                """;

        List<String> list = param.lines().toList();

        int nodeCount = Integer.parseInt(list.get(0));

        int[] parentOfIndex = new int[nodeCount + 1];

        for (int i = 0; i < parentOfIndex.length; i++) {
            parentOfIndex[i] = i;
        }

        for (int i = 1; i < list.size(); i++) {
            List<Integer> list1 = Arrays.stream(list.get(i).split(" "))
                    .map(Integer::parseInt)
                    .toList();

            Integer a = list1.get(0);
            Integer b = list1.get(1);

            int rootParent = Math.min(getRootParent(a, parentOfIndex), getRootParent(b, parentOfIndex));

            parentOfIndex[a] = rootParent;
            parentOfIndex[b] = rootParent;
        }

        for (int i = 0; i < parentOfIndex.length; i++) {
            System.out.println("child: " + i + ", root: " + getRootParent(i, parentOfIndex));
        }

    }

    private static int getRootParent(int child, int[] parentOfIndex) {
        if (child == parentOfIndex[child]) {
            return child;
        }

        return getRootParent(parentOfIndex[child], parentOfIndex);
    }

}
