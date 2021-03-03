package implementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 알파벳 대문자와 0~9로만 구성된 문자열
 * 알파벳 대문자들은 오름차순으로 정렬,
 * 그리고 숫자들은 합쳐서 뒤에 concat 시키기
 */
public class Fourth {

    public static void main(String[] args) {
        String s = "AB8SDJ321K5AS";

        List<String> charList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        String[] split = s.split("");

        for (String value : split) {
            try {
                Integer integer = Integer.valueOf(value);
                intList.add(integer);
            } catch (NumberFormatException e) {
                charList.add(value);
            }
        }

        charList.sort(Comparator.naturalOrder());

        int total = 0;

        for (Integer integer : intList) {
            total+=integer;
        }

        StringBuilder stringBuffer = new StringBuilder();

        charList.forEach(stringBuffer::append);

        stringBuffer.append(total);

        System.out.println(stringBuffer.toString());

    }

}
