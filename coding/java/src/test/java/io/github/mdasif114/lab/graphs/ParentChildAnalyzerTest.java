package io.github.mdasif114.lab.graphs;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParentChildAnalyzerTest {

    @Test
    void returnsDepthFirstDescendants() {
        Map<Integer, List<Integer>> relationships = new LinkedHashMap<>();
        relationships.put(1, List.of(2, 3));
        relationships.put(2, List.of(4, 5));
        relationships.put(3, List.of(6));

        assertEquals(List.of(2, 4, 5, 3, 6),
                ParentChildAnalyzer.descendants(relationships, 1));
    }

    @Test
    void doesNotRecurseForeverOnCycle() {
        Map<Integer, List<Integer>> relationships = new LinkedHashMap<>();
        relationships.put(1, List.of(2));
        relationships.put(2, List.of(1, 3));
        relationships.put(3, List.of());

        assertEquals(List.of(2, 3),
                ParentChildAnalyzer.descendants(relationships, 1));
    }
}
