package recursive;

/**
 * 최대공약수 계산 해봅시다.
 *
 * 두 자연수 A,B에 대해서 (A > B) A를 B로 나눈 나머지를 R이라고 하자
 *
 * 이때 A와 B의 최대 공약수는 B와 R의 최대공약수와 같다.
 * --> 이 아이디어(유클리드 호제법)을 재귀 함수에 적용해보자!!
 *
 */
public class 최대공약수계산 {

    public static void main(String[] args) {
        int value = getMaxDiv(192, 162);
        System.out.println(value);
    }

    private static int getMaxDiv(int i, int i1) {
        int mod = i % i1;
        if (mod == 0) {
            return i1;
        }

        return getMaxDiv(i1, mod);
    }

}
