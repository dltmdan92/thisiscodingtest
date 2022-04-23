package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * CHAPTER 11 그리디 문제 (p.311)
 * 01 모험가 길드
 */
public class AdventureGuild {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/chapter11/AdventureGuildParam.txt"));
        String countOfAdventurers = bufferedReader.readLine();
        int[] adventurers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int adventurer : adventurers) {
            queue.add(adventurer);
        }

        int neccessaryMembers = 0;
        int currentMembers = 0;
        int teamCount = 0;

        while(!queue.isEmpty()) {
            Integer adventurer = queue.poll();

            neccessaryMembers = Math.max(neccessaryMembers, adventurer);
            currentMembers++;

            if (neccessaryMembers == currentMembers) {
                teamCount++;
                currentMembers=0;
            }
        }

        System.out.println(teamCount);
    }

}
