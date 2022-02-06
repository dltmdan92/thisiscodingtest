package topology;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Curriculum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/topology/curriculum_param.txt"));

        int nodeCount = Integer.parseInt(bufferedReader.readLine());

        // 각 노드 별 선수 노드를 담기 위한 list
        List<List<Integer>> lineList = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            lineList.add(new ArrayList<>());
        }
        // 각 노드 별 cost
        int[] costList = new int[nodeCount + 1];
        // 각 노드 별 들어오는 간선 갯수
        int[] inputLineList = new int[nodeCount + 1];
        // 각 노드 까지의 거리
        int[] distances = new int[nodeCount + 1];

        String paramLine;
        int nodeNum = 1;
        while((paramLine = bufferedReader.readLine()) != null) {
            String[] params = paramLine.split(" ");

            int cost = Integer.parseInt(params[0]);
            costList[nodeNum] = cost;

            for (int i = 1; i < params.length; i++) {
                if ("-1".equals(params[i])) {
                    break;
                }

                int startNode = Integer.parseInt(params[i]);
                lineList.get(startNode).add(nodeNum);
                inputLineList[nodeNum]++;
            }
            distances[nodeNum] = Integer.MAX_VALUE;
            nodeNum++;
        }

        int startNode = getStartNode(nodeCount, inputLineList);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        distances[startNode] = costList[startNode];

        while(!queue.isEmpty()) {
            Integer start = queue.poll();

            List<Integer> targetNodes = lineList.get(start);
            for (Integer targetNode : targetNodes) {
                inputLineList[targetNode]--;
                // 선수 노드를 다 만족했을 경우
                if (inputLineList[targetNode] == 0) {
                    // queue에 적재
                    queue.add(targetNode);
                    int newDistance = distances[start] + costList[targetNode];
                    distances[targetNode] = Math.min(newDistance, distances[targetNode]);
                }
            }
        }

        for (int i = 1, distancesLength = distances.length; i < distancesLength; i++) {
            int distance = distances[i];
            System.out.println(distance);
        }


    }

    private static int getStartNode(int nodeCount, int[] inputLineList) {
        int startNode = 0;
        for (int i = 1; i <= nodeCount; i++) {
            if (inputLineList[i]==0) {
                startNode = i;
                break;
            }
        }
        return startNode;
    }

}
