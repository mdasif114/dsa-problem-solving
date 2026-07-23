package io.github.mdasif114.lab.reliability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SlidingWindowRateLimiterTest {

    @Test
    void rejectsRequestsUntilAnOldTimestampExpires() {
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter(3, 10);

        assertTrue(limiter.allowRequest("user-1", 1));
        assertTrue(limiter.allowRequest("user-1", 2));
        assertTrue(limiter.allowRequest("user-1", 3));
        assertFalse(limiter.allowRequest("user-1", 4));
        assertTrue(limiter.allowRequest("user-1", 11));
    }

    @Test
    void keepsClientsIndependentAndRequiresOrderedTimestamps() {
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter(1, 60);

        assertTrue(limiter.allowRequest("user-1", 10));
        assertTrue(limiter.allowRequest("user-2", 1));
        assertThrows(IllegalArgumentException.class,
                () -> limiter.allowRequest("user-1", 9));
    }
}
