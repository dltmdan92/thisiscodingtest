package greedy;

import java.util.*;

/**
 * 모험가 길드
 * 한 마을에 모험가가 N명, 모험가 길드는 N명의 모험가를 대상으로 '공포도' 측정
 * '공포도'가 높으면 쉽게 공포를 느껴 위험 상황에서 제대로 대처할 능력이 떨어진다.
 *
 * 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 한다.
 * Q) N명의 모험가에 대한 정보가 주어졌을 때, 여행을 떠날 수 있는 그룹 수의 최댓값을 구하라!!!
 *
 * 예시) N = 5이고, 각 모험가의 공포도는 2 3 1 2 2 이다.
 * --> {1,2,3} {2,2}
 *
 * 몇명의 모험가는 마을에 남아도 된다.
 *
 *
 * 힌트!! 오름차순 정렬 이후에 공포도가 낮은 모험가 순서대로 매칭!!!
 */
public class Fourth {

    public static void main(String[] args) {
        int n = 5;
        int[] ads = {1,1,1,2,2,2,2,2,3,3,3,3,4,4};
        int total = 0;
        int currentCnt = 0;

        // 정답 시작
        List<Integer> list = new ArrayList<>(ads.length);

        for (int i : ads) {
            list.add(i);
        }

        list.sort(Comparator.naturalOrder());

        for (int i = 0; i < list.size(); i++) {
            currentCnt++;
            if (list.get(i) <= currentCnt) {
                total++;
                currentCnt = 0;
            }
        }
        // 정답 끝 ㅠㅠ

        /*
        // 내 풀이 ㅠㅠ, 완전 틀림
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(ads).forEach(ad -> {
            if (map.get(ad) == null) {
                map.put(ad, 1);
            }
            else {
                Integer cnt = map.get(ad) + 1;
                map.put(ad, cnt);
            }
        });

        Integer[] keys = map.keySet().toArray(new Integer[map.keySet().size()]);

        for(Integer key : keys) {
            Integer keyCount = map.get(key);
            int sameKeyTeamCnt = keyCount / key;
            total += sameKeyTeamCnt;
            int modCount = keyCount - sameKeyTeamCnt * key;
            if (modCount == 0) {
                map.remove(key);
            }
            else {
                map.replace(key, modCount);
            }
        }

        Integer[] modKeys = map.keySet().toArray(new Integer[map.keySet().size()]);

        List<Integer> modKeyList = Arrays.asList(modKeys);

        for(Integer modKey : modKeyList) {
            Integer keyCount = map.get(modKey);
            int
        }
        */
        System.out.println(total);

    }

}
