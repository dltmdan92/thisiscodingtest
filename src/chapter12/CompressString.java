package chapter12;

import java.util.ArrayList;
import java.util.List;

public class CompressString {

    public static void main(String[] args) {
        String param = "xababcdcdababcdcd";
        int midLength = param.length() / 2;
        int lastPoint = param.length() - 1;
        int result = Integer.MAX_VALUE;

        for (int sliceSize = 1; sliceSize <= midLength; sliceSize++) {
            int currentMatchCount = 0;

            int startIndex = 0;
            int endIndex = startIndex + sliceSize - 1;
            String currentString = param.substring(startIndex, endIndex + 1);

            int sum = 0;
            int leftStringCount = param.length();
            List<Integer> matchCountList = new ArrayList<>();

            while(endIndex <= lastPoint - sliceSize) {
                int compareTargetStartIndex = startIndex + sliceSize;
                int compareTargetEndIndex = endIndex + sliceSize;
                String compareTarget = param.substring(compareTargetStartIndex, compareTargetEndIndex + 1);

                if (currentString.equals(compareTarget)) {
                    currentMatchCount++;
                    startIndex = compareTargetStartIndex;
                    endIndex = compareTargetEndIndex;
                }
                else {
                    if (currentMatchCount != 0 ) {
                        matchCountList.add(currentMatchCount + 1);
                    }
                    startIndex++;
                    endIndex++;
                    currentString = param.substring(startIndex, endIndex + 1);
                    currentMatchCount = 0;
                }
            }
            if (currentMatchCount != 0 ) {
                matchCountList.add(currentMatchCount + 1);
            }

            for (Integer matchCount : matchCountList) {
                sum += (sliceSize + 1);
                leftStringCount -= (matchCount * sliceSize);
            }

            result = Math.min(result, sum + leftStringCount);
        }
        System.out.println(result);
    }

}
