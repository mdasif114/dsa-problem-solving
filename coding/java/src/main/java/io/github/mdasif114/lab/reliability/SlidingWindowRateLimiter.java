package io.github.mdasif114.lab.reliability;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public final class SlidingWindowRateLimiter {

    private final int maxRequests;
    private final long windowSeconds;
    private final Map<String, Deque<Long>> acceptedTimestamps = new HashMap<>();

    public SlidingWindowRateLimiter(int maxRequests, long windowSeconds) {
        if (maxRequests <= 0) {
            throw new IllegalArgumentException("maxRequests must be positive");
        }
        if (windowSeconds <= 0) {
            throw new IllegalArgumentException("windowSeconds must be positive");
        }
        this.maxRequests = maxRequests;
        this.windowSeconds = windowSeconds;
    }

    public boolean allowRequest(String clientId, long timestampSeconds) {
        if (clientId == null || clientId.isBlank()) {
            throw new IllegalArgumentException("clientId must not be blank");
        }
        if (timestampSeconds < 0) {
            throw new IllegalArgumentException("timestampSeconds must not be negative");
        }

        Deque<Long> timestamps = acceptedTimestamps.computeIfAbsent(
                clientId, ignored -> new ArrayDeque<>());

        Long lastTimestamp = timestamps.peekLast();
        if (lastTimestamp != null && timestampSeconds < lastTimestamp) {
            throw new IllegalArgumentException(
                    "timestamps must be non-decreasing for each client");
        }

        long cutoff = timestampSeconds >= windowSeconds
                ? timestampSeconds - windowSeconds
                : -1;

        while (!timestamps.isEmpty() && timestamps.peekFirst() <= cutoff) {
            timestamps.removeFirst();
        }

        if (timestamps.size() >= maxRequests) {
            return false;
        }

        timestamps.addLast(timestampSeconds);
        return true;
    }
}
