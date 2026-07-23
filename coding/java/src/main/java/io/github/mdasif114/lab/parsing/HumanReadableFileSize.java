package io.github.mdasif114.lab.parsing;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;

public final class HumanReadableFileSize {

    private static final Map<String, Long> MULTIPLIERS = Map.of(
            "B", 1L,
            "KB", 1L << 10,
            "MB", 1L << 20,
            "GB", 1L << 30,
            "TB", 1L << 40
    );

    private HumanReadableFileSize() {
    }

    public static long toBytes(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("File size must not be blank");
        }

        String[] parts = value.trim().toUpperCase(Locale.ROOT).split("\\s+");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Expected '<value> <unit>'");
        }

        BigDecimal amount;
        try {
            amount = new BigDecimal(parts[0]);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("File size value must be numeric", exception);
        }

        if (amount.signum() < 0) {
            throw new IllegalArgumentException("File size must not be negative");
        }

        Long multiplier = MULTIPLIERS.get(parts[1]);
        if (multiplier == null) {
            throw new IllegalArgumentException("Unsupported file-size unit: " + parts[1]);
        }

        try {
            return amount.multiply(BigDecimal.valueOf(multiplier)).longValueExact();
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException("File size does not fit an exact long", exception);
        }
    }
}
