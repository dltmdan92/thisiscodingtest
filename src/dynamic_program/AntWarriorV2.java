package dynamic_program;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AntWarriorV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/dynamic_program/AntWarrior.txt"));

        int nodes = Integer.parseInt(bufferedReader.readLine());

        int[] array = new int[nodes + 1];
        int[] results = new int[nodes + 1];

        String[] split = bufferedReader.readLine().split(" ");
        for (int i = 0, splitLength = split.length; i < splitLength; i++) {
            String node = split[i];
            array[i + 1] = Integer.parseInt(node);
        }

        results[1] = array[1];

        for (int i = 2; i < array.length; i++) {
            results[i] = Math.max(results[i - 1], results[i - 2] + array[i]);
        }

        System.out.println(results[nodes]);
    }

}
