package yogiyo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MakeDistinct {

    public static void main(String[] args) {
        int[] n = {6, 2, 3, 5, 6, 3};
        int lastValue = 0;
        int modifyCount = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int j : n) {
            priorityQueue.add(j);
        }

        while(!priorityQueue.isEmpty()) {
            Integer nowNum = priorityQueue.poll();

            Integer targetNum = lastValue + 1;

            modifyCount += Math.abs(nowNum - targetNum);

            lastValue++;
        }

        System.out.println(modifyCount);
    }

}
