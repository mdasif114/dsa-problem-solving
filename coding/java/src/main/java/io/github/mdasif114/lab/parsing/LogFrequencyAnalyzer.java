package io.github.mdasif114.lab.parsing;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public final class LogFrequencyAnalyzer {

    private LogFrequencyAnalyzer() {
    }

    public static Map<String, Integer> countLevels(Collection<String> logs) {
        Objects.requireNonNull(logs, "logs must not be null");

        Map<String, Integer> counts = new TreeMap<>();
        for (String log : logs) {
            if (log == null || log.isBlank()) {
                throw new IllegalArgumentException("Log record must not be blank");
            }

            int separator = log.indexOf(' ');
            if (separator <= 0 || separator == log.length() - 1) {
                throw new IllegalArgumentException(
                        "Log record must contain a level and message: " + log);
            }

            String level = log.substring(0, separator);
            counts.merge(level, 1, Integer::sum);
        }

        return Collections.unmodifiableMap(counts);
    }
}
