package binary_search;

/**
 * logN의 속도를 낼 것!!
 *
 * 정렬된 데이터 임을 유념하라
 * 
 * 겨우 풀었다.... ㅠㅠㅠ
 */
public class 특정수의갯수 {
    static int currentLowVal;
    static int currentHighVal;
    static int firstIdx;
    static int lastIdx = 0;
    static int n = 2;

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,6,6,6,7};
        firstIdx = nums.length;
        currentLowVal = nums[nums.length - 1];
        currentHighVal = nums[0];
        binarySearch(nums, 0, nums.length - 1);
        System.out.println(lastIdx - firstIdx + 1);
    }

    private static void binarySearch(int[] nums, int strtIdx, int endIdx) {
        int mid = (strtIdx + endIdx) / 2;
        System.out.println("strtIdx : " + strtIdx);
        System.out.println("endIdx : " + endIdx);
        System.out.println("================================");
        for (int i = strtIdx; i <= mid; i++) {
            if (nums[i] == n && i <= firstIdx) firstIdx = i;
        }

        for (int i = endIdx; i > mid; i--) {
            if (nums[i] == n && i >= lastIdx) lastIdx = i;
        }

        // 앞으로 찾을 영역의 최대 값이 n과 크거나 같아야 한다. 쓸데 없는 영역 조회 안함
        if (mid > strtIdx && nums[mid] >= n)
            binarySearch(nums, strtIdx, mid);
        // 앞으로 찾을 영역의 최소 값이 n과 작거나 같아야 한다. 쓸데 없는 영역 조회 안함
        if (endIdx > mid && nums[mid] <= n)
            binarySearch(nums, mid + 1, endIdx);
    }
}
