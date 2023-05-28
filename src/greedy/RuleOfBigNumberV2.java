package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class RuleOfBigNumberV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("C:\\Users\\user\\IdeaProjects\\thisiscodingtest\\src\\greedy\\rule_of_big_number_param.txt"));

        String[] firstLine = bufferedReader.readLine().split(" ");
        int numCount = Integer.parseInt(firstLine[0]);
        int operationCount = Integer.parseInt(firstLine[1]);
        int maxDupCount = Integer.parseInt(firstLine[2]);

        String[] secondLine = bufferedReader.readLine().split(" ");
        int[] nums = Stream.of(secondLine)
                .map(Integer::valueOf)
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .mapToInt(Integer::intValue)
                .toArray();

        int max = nums[0];
        int second = nums[1];

        int cycle = maxDupCount + 1;

        int cycleCount = operationCount / cycle;
        int mod = operationCount % cycle;

        int sumOfCycles = cycleCount * (max * maxDupCount + second);
        int sumOfMods = mod * max;

        System.out.println(sumOfCycles + sumOfMods);
    }
}
