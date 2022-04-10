package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class TeamMakingV2 {
    private static final int CMD_UNITE = 0;
    private static final int CMD_CHECK = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/graph/team_making_param.txt"));
        String firstLine = bufferedReader.readLine();
        int[] firstLineElements = Arrays.stream(firstLine.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int n = firstLineElements[0];
        int m = firstLineElements[1];

        int[] roots = new int[n + 1];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }


        for (int i = 0; i < m; i++) {
            int[] elementsOfLine = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int command = elementsOfLine[0];
            int student1 = elementsOfLine[1];
            int student2 = elementsOfLine[2];

            roots[student1] = findRoot(roots, student1);
            roots[student2] = findRoot(roots, student2);

            if (command == CMD_UNITE) {


                if (roots[student1] < roots[student2]) {
                    roots[student2] = roots[student1];
                }
                else {
                    roots[student1] = roots[student2];
                }

            }
            else if (command == CMD_CHECK) {
                if (roots[student1] == roots[student2])
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    private static int findRoot(int[] roots, int student) {
        if (roots[student] == student)
            return student;

        int rootOfStudent = roots[student];
        return findRoot(roots, rootOfStudent);
    }
}
