package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 두 배열의 원소교체를 해서
 * 첫번째 배열의 총합이 MAX가 되도록 하라!!
 * N (1 ~ 1000000)   ,    K (0 ~ N)
 * 총 K 번 연산 할 수 있다.
 */
public class 두배열의원소교체 {

    public static void main(String[] args) {
        int K = 3;
        int[] A = {1,2,5,4,3};
        int[] B = {5,5,6,6,5};

        // STEP 1. A는 오름차순으로 정렬!
        List<Integer> aList = new ArrayList<>();
        for(int a : A) {
            aList.add(a);
        }
        aList.sort(Comparator.naturalOrder());

        // STEP 2. B는 내림차순으로 정렬!
        List<Integer> bList = new ArrayList<>();
        for(int b : B) {
            bList.add(b);
        }
        bList.sort(Comparator.reverseOrder());

        // STEP 3. 교체 작업
        for (int i = 0; i < K; i++) {
            if (aList.get(i) < bList.get(i)) {
                aList.set(i, bList.get(i));
            }
        }

        // STEP 4. 합치기 작업
        int result = 0;
        for(Integer a : aList) {
            result+=a;
        }

        System.out.println(result);

    }

}
