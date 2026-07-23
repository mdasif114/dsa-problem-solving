package io.github.mdasif114.lab.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class ParentChildAnalyzer {

    private ParentChildAnalyzer() {
    }

    public static List<Integer> descendants(
            Map<Integer, List<Integer>> relationships,
            int processId) {
        Objects.requireNonNull(relationships, "relationships must not be null");

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(processId);
        visit(relationships, processId, visited, result);
        return List.copyOf(result);
    }

    private static void visit(
            Map<Integer, List<Integer>> relationships,
            int processId,
            Set<Integer> visited,
            List<Integer> result) {
        List<Integer> children = relationships.get(processId);
        if (children == null) {
            return;
        }

        for (Integer child : children) {
            if (child == null) {
                throw new IllegalArgumentException("Child process ID must not be null");
            }
            if (visited.add(child)) {
                result.add(child);
                visit(relationships, child, visited, result);
            }
        }
    }
}
