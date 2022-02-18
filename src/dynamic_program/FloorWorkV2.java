package dynamic_program;

public class FloorWorkV2 {

    public static void main(String[] args) {
        int n = 3;

        int[] array = new int[n + 1];

        array[0] = 1;

        for (int i = 1; i < array.length; i++) {
            int b1 = i - 1;
            int b2 = i - 2;

            int fromB1 = array[b1];
            int fromB2 = (b2 >= 0) ? array[b2] * 2 : 0;

            array[i] = fromB1 + fromB2;
        }
        int result = array[n] % 796_796;
        System.out.println(result);
    }

}
