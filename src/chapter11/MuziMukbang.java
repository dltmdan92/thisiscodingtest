package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MuziMukbang {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/chapter11/MuziMukbangParam.txt"));
        int[] foodTimes = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        int k = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Food> pq = new PriorityQueue<>(Comparator.comparing(Food::getTime));

        for (int i = 0; i < foodTimes.length; i++) {
            int foodTime = foodTimes[i];
            pq.add(Food.makeFood(foodTime, i + 1));
        }

        if (k < foodTimes.length) {
            System.out.println(foodTimes.length - k);
        }

        int total = 0;
        for (int foodTime : foodTimes) {
            total+=foodTime;
        }
        if (total < k) {
            System.out.println(-1);
            return;
        }

        int usedTime = 0;
        Food smallestFood = pq.poll();
        int foodsRemaining = foodTimes.length;

        while((smallestFood.getTime()) * foodsRemaining + usedTime <= k) {
            usedTime += smallestFood.getTime() * foodsRemaining;
            smallestFood = pq.poll().minusAndGet(smallestFood.getTime());
            foodsRemaining--;
        }

        List<Food> foods = new ArrayList<>();
        foods.add(smallestFood);
        for (int i = 0; i < foodsRemaining - 1; i++) {
            foods.add(pq.poll());
        }
        foods.sort(Comparator.comparing(Food::getNum));
        int index = (k - usedTime) % foodsRemaining;
        System.out.println(foods.get(index).getNum());
    }

    private static class Food {
        private int time;
        private int num;

        private Food(int time, int num) {
            this.time = time;
            this.num = num;
        }

        private static Food makeFood(int time, int num) {
            return new Food(time, num);
        }

        public int getTime() {
            return time;
        }

        public int getNum() {
            return num;
        }

        public Food minusAndGet(int time) {
            this.time -= time;
            return this;
        }
    }
}
