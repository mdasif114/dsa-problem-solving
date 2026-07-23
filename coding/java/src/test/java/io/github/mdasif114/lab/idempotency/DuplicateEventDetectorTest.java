package io.github.mdasif114.lab.idempotency;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DuplicateEventDetectorTest {

    @Test
    void detectsRepeatedEventIds() {
        assertTrue(DuplicateEventDetector.containsDuplicate(
                List.of("TX-1001", "TX-1002", "TX-1001")));
        assertFalse(DuplicateEventDetector.containsDuplicate(
                List.of("TX-1001", "TX-1002")));
    }

    @Test
    void rejectsNullEventId() {
        assertThrows(IllegalArgumentException.class,
                () -> DuplicateEventDetector.containsDuplicate(
                        Arrays.asList("TX-1001", null)));
    }
}
