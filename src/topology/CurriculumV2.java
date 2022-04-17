package topology;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CurriculumV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/topology/curriculum_param.txt"));
        String firstLine = bufferedReader.readLine();
        int nodeCount = Integer.parseInt(firstLine);

        int[] costs = new int[nodeCount + 1];
        Arrays.fill(costs, 0);
        int[] resultCosts = new int[nodeCount + 1];
        Arrays.fill(resultCosts, 0);
        int[] indegrees = new int[nodeCount + 1];
        Arrays.fill(indegrees, 0);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int course = 1; course < graph.size(); course++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            costs[course] = line[0];

            for (int j = 1; j < line.length - 1; j++) {
                int precourse = line[j];
                indegrees[course]++;
                graph.get(precourse).add(course);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
                resultCosts[i] = costs[i];
            }
        }

        while(!queue.isEmpty()) {
            Integer course = queue.poll();
            List<Integer> nextCourses = graph.get(course);
            nextCourses.forEach(nextCourse -> {
                indegrees[nextCourse]--;
                resultCosts[nextCourse] = Math.max(resultCosts[nextCourse], costs[nextCourse] + resultCosts[course]);
                if (indegrees[nextCourse] < 1) {
                    queue.add(nextCourse);
                }
            });
        }

        System.out.println(Arrays.toString(indegrees));
        System.out.println(Arrays.toString(resultCosts));
    }

}
