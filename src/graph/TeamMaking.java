package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeamMaking {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/graph/team_making_param.txt"));

        String[] firstLine = bufferedReader.readLine().split(" ");
        int maxNumber = Integer.parseInt(firstLine[0]);
        int studentCount = maxNumber + 1;
        int actionCount = Integer.parseInt(firstLine[1]);

        List<Integer> rootOfEachStudents = new ArrayList<>();
        for (int i = 0; i < studentCount + 1; i++) {
            rootOfEachStudents.add(i);
        }

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] inputLine = line.split(" ");

            String action = inputLine[0];
            int student1 = Integer.parseInt(inputLine[1]);
            int student2 = Integer.parseInt(inputLine[2]);

            // 팀 합치기
            if (isUnion(action)) {
                union(student1, student2, rootOfEachStudents);
            }
            // 팀 확인
            else {
                boolean sameTeam = isSameTeam(student1, student2, rootOfEachStudents);
                System.out.println((sameTeam) ? "YES" : "NO");
            }

        }
    }

    private static boolean isSameTeam(int student1, int student2, List<Integer> rootOfEachStudents) {
        Integer rootOfStudent1 = findRoot(student1, rootOfEachStudents);
        Integer rootOfStudent2 = findRoot(student2, rootOfEachStudents);
        return rootOfStudent1.equals(rootOfStudent2);
    }

    private static void union(int student1, int student2, List<Integer> rootOfEachStudents) {
        Integer rootOfStudent1 = findRoot(student1, rootOfEachStudents);
        Integer rootOfStudent2 = findRoot(student2, rootOfEachStudents);
        if (rootOfStudent1 < rootOfStudent2) {
            rootOfEachStudents.set(student2, rootOfStudent1);
        }
        else {
            rootOfEachStudents.set(student1, rootOfStudent2);
        }
    }

    private static int findRoot(int student, List<Integer> rootOfEachStudents) {
        Integer root = rootOfEachStudents.get(student);

        if (!Objects.equals(root, rootOfEachStudents.get(root))) {
            int realRoot = findRoot(rootOfEachStudents.get(root), rootOfEachStudents);
            rootOfEachStudents.set(student, realRoot);
        }

        return rootOfEachStudents.get(student);
    }

    private static boolean isUnion(String action) {
        return "0".equals(action);
    }

}
