package io.github.mdasif114.lab.idempotency;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class DuplicateEventDetector {

    private DuplicateEventDetector() {
    }

    public static boolean containsDuplicate(Collection<String> eventIds) {
        Objects.requireNonNull(eventIds, "eventIds must not be null");

        Set<String> seen = new HashSet<>();
        for (String eventId : eventIds) {
            if (eventId == null) {
                throw new IllegalArgumentException("event ID must not be null");
            }
            if (!seen.add(eventId)) {
                return true;
            }
        }
        return false;
    }
}
