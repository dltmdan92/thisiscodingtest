package jaewoong;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] param = {
                {1,1,1,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,1},
                {0,0,0,1,0,1,0,0,1},
                {1,1,0,0,1,0,0,0,1}
        };
        System.out.println(solution.solution(param));
    }
}
