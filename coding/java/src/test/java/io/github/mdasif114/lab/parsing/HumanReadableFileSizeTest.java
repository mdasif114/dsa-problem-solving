package io.github.mdasif114.lab.parsing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HumanReadableFileSizeTest {

    @Test
    void convertsBinaryUnits() {
        assertEquals(2_952_790_016L, HumanReadableFileSize.toBytes("2.75 GB"));
        assertEquals(1_024L, HumanReadableFileSize.toBytes("1 KB"));
    }

    @Test
    void rejectsMalformedAndNonExactValues() {
        assertThrows(IllegalArgumentException.class,
                () -> HumanReadableFileSize.toBytes("1.5 B"));
        assertThrows(IllegalArgumentException.class,
                () -> HumanReadableFileSize.toBytes("10 XB"));
        assertThrows(IllegalArgumentException.class,
                () -> HumanReadableFileSize.toBytes("not-a-size"));
    }
}
