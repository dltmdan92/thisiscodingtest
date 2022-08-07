package jaewoong;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int solution(int[][] factory) {
        int answer = 0;

        // key: part, value: factories
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> uncontractedFactories = new HashSet<>();

        for (int factoryNum = 0; factoryNum < factory.length; factoryNum++) {
            int[] partsOfFactory = factory[factoryNum];
            uncontractedFactories.add(factoryNum);

            for (int partNum = 0; partNum < partsOfFactory.length; partNum++) {
                int part = partsOfFactory[partNum];
                Set<Integer> factories = map.get(partNum);
                if (factories == null) {
                    map.put(partNum, new HashSet<>());
                    factories = map.get(partNum);
                }
                if (part == 1) {
                    factories.add(factoryNum);
                }
            }
        }

        List<Integer> partsOrderedDesc = getPartsOrderedDesc(map);
        Integer part = partsOrderedDesc.get(0);
        Set<Integer> factories = map.get(part);

        factories.forEach(uncontractedFactories::remove);
        answer++;

        while(!uncontractedFactories.isEmpty()) {
            List<Integer> partsOrderByUncontractedCount = getPartsOrderedDesc(map, uncontractedFactories);
            Integer uncontractedPart = partsOrderByUncontractedCount.get(0);
            Set<Integer> contractFactories = map.get(uncontractedPart);

            contractFactories.forEach(uncontractedFactories::remove);
            answer++;
        }

        return answer;
    }

    private List<Integer> getPartsOrderedDesc(Map<Integer, Set<Integer>> map, Set<Integer> uncontractedFactories) {
        List<Integer> partsOrderByUncontractedCount = map.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> getCountMatchingFactories(uncontractedFactories, entry.getValue())))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        Collections.reverse(partsOrderByUncontractedCount);
        return partsOrderByUncontractedCount;
    }

    private boolean isNotFactoryMatched(Set<Integer> uncontractedFactories, Set<Integer> factories) {
        return uncontractedFactories.stream()
                .filter(factories::contains)
                .findAny()
                .isEmpty();
    }

    private int getCountMatchingFactories(Set<Integer> uncontractedFactories, Set<Integer> factories) {
        return (int) uncontractedFactories.stream()
                .filter(factories::contains)
                .count();
    }

    private static List<Integer> getPartsOrderedDesc(Map<Integer, Set<Integer>> map) {
        List<Integer> partsOrderedByFactoryCount = map.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().size()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Collections.reverse(partsOrderedByFactoryCount);
        return partsOrderedByFactoryCount;
    }

}
