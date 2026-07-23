package io.github.mdasif114.lab.aggregation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TopKFailingServicesTest {

    @Test
    void ranksByCountThenName() {
        assertEquals(
                List.of("payment", "search"),
                TopKFailingServices.topK(List.of(
                        "payment", "search", "payment", "orders",
                        "search", "payment", "inventory", "search"), 2));
    }

    @Test
    void handlesNonPositiveAndOversizedK() {
        List<String> services = List.of("orders", "search");
        assertEquals(List.of(), TopKFailingServices.topK(services, 0));
        assertEquals(List.of("orders", "search"),
                TopKFailingServices.topK(services, 10));
    }
}
