package scofe;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Kurly {

    public static void main(String[] args) {
        String param = "11111111111111111111111111111111111111111111111111";
        int n = param.length();

        System.out.println("length : " + n);

        int zeroCount = 0;
        int totalCount = 0;

        String[] paramSplit = param.split("");

        for (String zeroOne: paramSplit) {
            if ("0".equals(zeroOne))
                zeroCount++;
        }

        System.out.println(zeroCount);

        // 이것이 진짜 찾아야할 경로의 기준 1 갯수
        int realOneCount = n - (zeroCount * 2) - 1;

        int maxTwoPathCount = realOneCount / 2;

        int minOnePathCount = realOneCount % 2;


        while(maxTwoPathCount >= 0 && minOnePathCount <= realOneCount) {
            System.out.println("maxTwoPathCount : " + maxTwoPathCount);
            System.out.println("minOnePathCount : " + minOnePathCount);
            int targetPathElement = maxTwoPathCount + minOnePathCount;

            long eachCount = 1;

            List<Integer> numList = new ArrayList<>();

            for (int i = targetPathElement; i > Math.max(maxTwoPathCount, minOnePathCount); i--) {
                numList.add(i);
            }

            for (Integer num: numList) {
                eachCount*=num;
            }

            int minOneCount = Math.min(maxTwoPathCount, minOnePathCount);

            for (int i = minOneCount; i >= 1; i--) {
                eachCount/=i;
            }

            totalCount += eachCount;
            maxTwoPathCount--;
            minOnePathCount+=2;
        }

        System.out.println(totalCount);
    }

}
