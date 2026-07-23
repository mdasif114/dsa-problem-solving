package io.github.mdasif114.lab.parsing;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public final class IpRequestCounter {

    private IpRequestCounter() {
    }

    public static Map<String, Integer> countByClient(Collection<String> logs) {
        Objects.requireNonNull(logs, "logs must not be null");

        Map<String, Integer> counts = new TreeMap<>();
        for (String log : logs) {
            if (log == null || log.isBlank()) {
                throw new IllegalArgumentException("Log record must not be blank");
            }

            String normalized = log.trim();
            int separator = normalized.indexOf(' ');
            if (separator <= 0 || separator == normalized.length() - 1) {
                throw new IllegalArgumentException(
                        "Log record must contain a client and path: " + log);
            }

            String client = normalized.substring(0, separator);
            counts.merge(client, 1, Integer::sum);
        }

        return Collections.unmodifiableMap(counts);
    }
}
