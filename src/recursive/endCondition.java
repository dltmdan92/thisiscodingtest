package recursive;

/**
 * 재귀 함수의 종료 조건
 * 재귀 함수를 문제 풀이에서 사용할 때는 재귀 함수의 종료 조건을 반드시 명시해야 한다.
 *
 * 종료 조건을 포함한 재귀함수 예제
 */
public class endCondition {

    public static void main(String[] args) {
        recursiveFunc(1);
    }

    private static void recursiveFunc(int i) {
        // 100번째 호출을 했을 때 종료되도록 종료 조건 명시
        if (i == 100) {
            return;
        }
        System.out.println(i + "번째 재귀함수에서 " + (i+1) + "번째 재귀함수를 호출합니다.");
        recursiveFunc(i+1);
        System.out.println(i + "번째 재귀함수를 종료합니다.");
    }

}
