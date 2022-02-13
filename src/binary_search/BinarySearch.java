package binary_search;

public class BinarySearch {
    private static int value = 0;

    public static void main(String[] args) {
        int[] array = {0,2,4,6,8,10,12,14,16,18};
        int start = 0;
        value = 4;
        int end = array.length - 1;

        int result = binarySearch(array, start, end);
        System.out.println(result);
    }

    private static int binarySearch(int[] array, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (array[mid] == value) {
            return mid;
        }

        if (array[mid] > value) {
            return binarySearch(array, start, mid - 1);
        }
        else {
            return binarySearch(array, mid + 1, end);
        }
    }

}
