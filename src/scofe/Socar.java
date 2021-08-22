package scofe;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;

public class Socar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = Files.newBufferedReader(Path.of("D:\\work\\workspace\\IdeaProjects\\thisiscodingtest\\src\\scofe\\socar.txt"));

        LocalTime maxStrtTime = LocalTime.of(0, 0);
        LocalTime minEndTime = LocalTime.of(23, 59);

        String input = br.readLine();
        String line;

        while((line = br.readLine()) != null) {
            String[] split = line.trim().split("~");

            String strtTimeStr = split[0];
            String endTimeStr = split[1];

            String[] strtHourMinute = strtTimeStr.split(":");

            String[] endHourMinute = endTimeStr.split(":");
            // 시작 시간
            LocalTime strtTime = LocalTime.of(Integer.parseInt(processNum(strtHourMinute[0])), Integer.parseInt(processNum(strtHourMinute[1])));
            // 종료 시간
            LocalTime endTime = LocalTime.of(Integer.parseInt(processNum(endHourMinute[0])), Integer.parseInt(processNum(endHourMinute[1])));

            if (strtTime.isAfter(maxStrtTime))
                maxStrtTime = strtTime;
            if (endTime.isBefore(minEndTime))
                minEndTime = endTime;
        }

        if (maxStrtTime.isBefore(minEndTime))
            System.out.println(maxStrtTime.toString() +" ~ "+minEndTime.toString());
        else
            System.out.println("-1");
    }

    private static String processNum(String num) {
        if ("0".equals(String.valueOf(num.charAt(0)))) {
            num.replaceAll("0", "");
        }
        if (num.isEmpty())
            return "0";
        return num.trim();
    }
}
