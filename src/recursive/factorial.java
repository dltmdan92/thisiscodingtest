package recursive;

/**
 * n! = 1 * 2* 3 * ..... * (n-1) * n
 *
 * 수학적으로 0! 과 1!의 값은 1이다.
 */
public class factorial {
    public static void main(String[] args) {
        System.out.println(iterator(10));
        System.out.println(resursive(10));
    }

    /**
     * 재귀함수로 팩토리얼 표현
     * 재귀함수는 "종료 조건"을 명시하는 것 항상 기억!!!
     * @param i
     */
    private static int resursive(int i) {
        // 종료 조건
        if (i == 0) {
            return 1;
        }

        return i * resursive(i - 1);
    }

    /**
     * 반복문으로 팩토리얼 표현
     * @param i
     * @return
     */
    private static int iterator(int i) {
        int result = 1;

        if (i == 0) {
            return 1;
        }

        for(int idx = 1; idx <= i; idx++) {
            System.out.println(result);
            result = result * idx;
        }

        return result;
    }
}
