package sorting;

import java.util.*;
import java.util.stream.Collectors;

public class TopToBottom {
    public static void main(String[] args) {
        String paramString = ParamsKt.topToBottomParam();

        List<Integer> params = Arrays.stream(paramString.split("\n"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i < params.size(); i++) {
            queue.add(params.get(i));
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + ", ");
        }

    }
}
