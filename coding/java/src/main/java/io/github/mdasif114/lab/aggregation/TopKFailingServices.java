package io.github.mdasif114.lab.aggregation;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class TopKFailingServices {

    private TopKFailingServices() {
    }

    public static List<String> topK(Collection<String> services, int k) {
        Objects.requireNonNull(services, "services must not be null");
        if (k <= 0) {
            return List.of();
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String service : services) {
            if (service == null || service.isBlank()) {
                throw new IllegalArgumentException("Service name must not be blank");
            }
            counts.merge(service, 1, Integer::sum);
        }

        return counts.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry::getKey))
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }
}
