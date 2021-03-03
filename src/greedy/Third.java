package greedy;

/**
 * 각 자리가 숫자 0~9 로만 이루어진 문자열 S,
 * 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에 * or + 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수
 * 단 +보다 *를 먼저 계산하는 일반적인 방식과는 달리, 모든 연산은 왼쪽부터 순서대로 이루어진다.
 * 02984 --> ((((0 + 2) * 9) * 8) * 4) = 576
 *
 * 힌트! ) 대부분의 경우 '+' 보다는 '*'가 더 값을 크게 만든다.
 * 다만 두 수중의 하나가 0 / 1 일 경우에는 더하기를 해준다!!
 */
public class Third {

    public static void main(String[] args) {
        String s = "02984";

        String[] split = s.split("");

        int total = 0;

        for (int i = 0; i < split.length; i++) {
            Integer nowNum = Integer.valueOf(split[i]);
            /* // 내 풀이 ㅠㅠ 정답은 맞으나 비효율적 ㅠㅠ
            if (i == 0) {
                total += nowNum;
            }
            else {
                if (total == 0 || nowNum == 0) {
                    total+=nowNum;
                    continue;
                }
                if (total * nowNum > total + nowNum) {
                    total *= nowNum;
                }
                else {
                    total += nowNum;
                }
            }*/
            if (nowNum <= 1 || total <= 1) {
                total += nowNum;
            }
            else {
                total *= nowNum;
            }
        }

        System.out.println(total);
    }

}
