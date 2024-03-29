package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class PeekBall {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/chapter11/PeekBallParam.txt"));
        int[] nm = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int numOfBalls = nm[0];
        int maxNumOfBall = nm[1];

        int[] balls = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int[] ballAggr = new int[maxNumOfBall + 1];

        for (int ball : balls) {
            ballAggr[ball]++;
        }

        int total = 0;

        for (int currentBall = 1; currentBall < ballAggr.length; currentBall++) {
            int currentBallCount = ballAggr[currentBall];
            numOfBalls-=currentBallCount;
            total += numOfBalls * currentBallCount;
        }

        System.out.println(total);

    }

}
