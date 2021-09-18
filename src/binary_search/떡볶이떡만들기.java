package binary_search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 떡볶이떡만들기 {
    // 떡의 갯수
    static int n = 4;

    // 요청한 떡의 길이
    static int m = 5;

    static int result = 0;

    public static void main(String[] args) {
        String rcksStr = "19 15 10 17";

        String[] rckArr = rcksStr.split(" ");

        // STEP 1. 리스트 데이터 만들기
        List<Integer> rckList = new ArrayList<>(rckArr.length);

        for(String rckElement : rckArr) {
            Integer rck = Integer.valueOf(rckElement);
            rckList.add(rck);
        }
        rckList.sort(Comparator.naturalOrder());
        System.out.println(rckList);

        // STEP 2. 이진 탐색 시작
        // STEP 2-1. 가장 긴 것 추출
        Integer longestRck = rckList.get(rckList.size() - 1);
        // STEP 2-2. 가장 긴것의 절반내기
        int div = longestRck / 2;

        extracted(rckList, div);
        System.out.println(result);

    }

    private static void extracted(List<Integer> rckList, int startIdx) {
        if (startIdx <= rckList.get(rckList.size() - 1)) {
            int rckResult = 0;
            for (Integer rck : rckList) {
                if (rck > startIdx) {
                    rckResult += (rck - startIdx);
                }
            }

            // 작을 경우, startIdx가 더 작아져야 한다.
            if (rckResult < m) {
                extracted(rckList, startIdx - 1);
            }
            // 클 경우, startIdx를 더 크게 한다.
            else {
                if (startIdx > result) {
                    result = startIdx;
                    return;
                }
                result = startIdx;
                // 떡의 양이 충분할 경우, 최대한 덜 잘랏을 때가 정답이므로 일단 기록한다.
                extracted(rckList, startIdx + 1);
            }
        }
    }

}
