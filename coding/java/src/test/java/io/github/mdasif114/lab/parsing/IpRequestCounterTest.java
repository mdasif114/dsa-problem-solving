package io.github.mdasif114.lab.parsing;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IpRequestCounterTest {

    @Test
    void countsRequestsByFirstToken() {
        assertEquals(
                Map.of("10.0.0.5", 2, "172.16.0.2", 1, "192.168.1.10", 3),
                IpRequestCounter.countByClient(List.of(
                        "10.0.0.5 /home",
                        "192.168.1.10 /login",
                        "192.168.1.10 /products",
                        "172.16.0.2 /login",
                        "10.0.0.5 /cart",
                        "192.168.1.10 /checkout")));
    }

    @Test
    void rejectsRecordsWithoutPath() {
        assertThrows(IllegalArgumentException.class,
                () -> IpRequestCounter.countByClient(List.of("10.0.0.5")));
    }
}
