package chapter12;

import java.util.Arrays;

public class KeyAndLock {

    public static void main(String[] args) {
        int[][] key = {
                {0,0,0},
                {1,0,0},
                {0,1,1}
        };

        int[][] lock = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int lockLen = lock.length;

        int zeroExistsFirstRow = -1;
        int zeroExistsFirstCol = -1;

        for (int i = 0; i < lockLen; i++) {
            int[] row = lock[i];
            if (doesZeroExist(row)) {
                zeroExistsFirstRow = i;
                break;
            }
        }

        for (int i = 0; i < lockLen; i++) {
            int[] col = new int[lockLen];
            for (int j = 0; j < lockLen; j++) {
                col[j] = lock[j][i];
            }
            if (doesZeroExist(col)) {
                zeroExistsFirstCol = i;
                break;
            }
        }

        int keyWidth = lockLen - zeroExistsFirstRow;
        int keyHeight = lockLen - zeroExistsFirstCol;

        int[][] keyPointOfLock = new int[lockLen - zeroExistsFirstRow][lockLen - zeroExistsFirstCol];

        for (int row = zeroExistsFirstRow; row < lockLen; row++) {
            for (int col = zeroExistsFirstCol; col < lockLen; col++) {
                keyPointOfLock[row - zeroExistsFirstRow][col - zeroExistsFirstCol] = lock[row][col];
            }
        }

        boolean result = false;

        for (int rotateCount = 0; rotateCount < 3; rotateCount++) {
            boolean okay = isOkay(key, keyWidth, keyHeight, keyPointOfLock);
            if (okay) {
                result = true;
                break;
            }
            else {
                key = rotate(key);
                rotateCount++;
            }
        }

        System.out.println(result);

    }

    private static int[][] rotate(int[][] key) {
        int[][] newKey = new int[key.length][key.length];

        for (int row = 0; row < key.length; row++) {
            for (int col = 0; col < key.length; col++) {
                int newRow = col;
                int newCol = key.length - row - 1;
                newKey[newRow][newCol] = key[row][col];
            }
        }
        return newKey;
    }

    private static boolean isOkay(int[][] key, int keyWidth, int keyHeight, int[][] keyPointOfLock) {
        for (int row = 0; row < keyWidth; row++) {
            for (int col = 0; col < keyHeight; col++) {
                if (key[row][col] == 0 && keyPointOfLock[row][col] == 0) {
                    return false;
                }
                if (key[row][col] == 1 && keyPointOfLock[row][col] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean doesZeroExist(int[] row) {
        return Arrays.stream(row)
                .filter(num -> num == 0)
                .findAny().isPresent();
    }

}
