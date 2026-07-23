package io.github.mdasif114.lab.parsing;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LogFrequencyAnalyzerTest {

    @Test
    void countsLevelsDeterministically() {
        assertEquals(
                Map.of("ERROR", 2, "INFO", 1, "WARN", 1),
                LogFrequencyAnalyzer.countLevels(List.of(
                        "ERROR database unavailable",
                        "INFO request accepted",
                        "WARN retry scheduled",
                        "ERROR timeout")));
    }

    @Test
    void rejectsRecordsWithoutMessage() {
        assertThrows(IllegalArgumentException.class,
                () -> LogFrequencyAnalyzer.countLevels(List.of("ERROR")));
    }
}
