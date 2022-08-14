package chapter12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PillarAndBarrage {
    private static final int KIND_PILLAR = 0;
    private static final int KIND_BARRAGE = 1;

    private static final int ACTION_DELETE = 0;
    private static final int ACTION_CONSTRUCT = 1;

    public static void main(String[] args) {
        int n = 5;

        Integer[][] frame = {
            {0,0,0,1},
            {2,0,0,1},
            {4,0,0,1},
            {0,1,1,1},
            {1,1,1,1},
            {2,1,1,1},
            {3,1,1,1},
            {2,0,0,0},
                {1,1,1,0},
                {2,2,0,1}
        };

        boolean[][] constructed = new boolean[n + 2][n + 2];

        PriorityQueue<Integer[]> stepQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        PriorityQueue<Construct> constructQueue = new PriorityQueue<>(Comparator.comparing(Construct::getX).thenComparing(Construct::getY));

        stepQueue.addAll(Arrays.asList(frame));

        while(!stepQueue.isEmpty()) {
            Integer[] step = stepQueue.poll();
            int xPoint = step[0];
            int yPoint = step[1];
            int kind = step[2];
            int action = step[3];

            if (isPointNotInRange(xPoint, yPoint, n)) {
                continue;
            }

            // 기둥
            if (kind == KIND_PILLAR) {
                if (action == ACTION_CONSTRUCT) {
                    if (yPoint == 0 || constructed[xPoint][yPoint]) {
                        // 기둥 설치 기능
                        constructed[xPoint][yPoint + 1] = true;
                        constructQueue.add(new Construct(xPoint, yPoint, KIND_PILLAR));
                    }
                }
                else if (action == ACTION_DELETE) {
                    if (constructed[xPoint][yPoint + 1]) {
                        // 기둥 제거 가능
                        constructed[xPoint][yPoint + 1] = false;
                    }
                }
            }
            // 보
            else if (kind == KIND_BARRAGE) {
                if (action == ACTION_CONSTRUCT) {
                    if (yPoint != 0 && constructed[xPoint][yPoint]) {
                        // 보 설치 가능
                        constructed[xPoint + 1][yPoint] = true;
                        constructQueue.add(new Construct(xPoint, yPoint, KIND_BARRAGE));
                    }
                }
                else if (action == ACTION_DELETE) {
                    if (constructed[xPoint + 1][yPoint]) {
                        // 보 제거 가능
                        constructed[xPoint + 1][yPoint] = false;
                    }
                }
            }
        }

        while(!constructQueue.isEmpty()) {
            Construct construct = constructQueue.poll();

            int constructX = construct.getConstructX();
            int constructY = construct.getConstructY();

            if (construct.isPillar()) {

                if (construct.getY() == 0 || constructed[constructX][constructY]) {
                    System.out.println(construct);
                }

            }
            else {
                if (constructed[constructX][constructY]) {
                    System.out.println(construct);
                }
            }

        }
    }

    private static boolean isPointNotInRange(int xPoint, int yPoint, int n) {
        return !isPointInRange(xPoint, yPoint, n);
    }

    private static boolean isPointInRange(int xPoint, int yPoint, int n) {
        return xPoint >= 0 && xPoint <= n && yPoint >= 0 && yPoint <= n;
    }

    private static class Construct {
        private int x;
        private int y;
        private int kind;

        private Construct(int x, int y, int kind) {
            this.x = x;
            this.y = y;
            this.kind = kind;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getKind() {
            return kind;
        }

        public boolean isPillar() {
            return getKind() == KIND_PILLAR;
        }
        public boolean isBarrage() {
            return getKind() == KIND_BARRAGE;
        }
        public int getConstructX() {
            if (isBarrage()) {
                return x + 1;
            }
            return x;
        }
        public int getConstructY() {
            if (isPillar()) {
                return y + 1;
            }
            return y;
        }

        @Override
        public String toString() {
            return "[" + x +
                    "," + y +
                    "," + kind +
                    ']';
        }
    }

}
