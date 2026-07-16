import java.util.*;
import java.util.function.Supplier;

/**
 * P16 - Merge Sorted Log Streams
 * Evidence: Representative | Probability: High | Difficulty: Medium
 * Merge streams individually sorted by timestamp. Break timestamp ties by source
 * and then message. Preserve all entries; inputs must not be mutated.
 */
public class P16_MergeSortedLogStreams_Starter {
    public record LogEntry(long timestamp, String source, String message) {}

    public static List<LogEntry> mergeStreams(List<List<LogEntry>> streams) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        LogEntry a1 = new LogEntry(1, "a", "one");
        LogEntry a3 = new LogEntry(3, "a", "three");
        LogEntry b2 = new LogEntry(2, "b", "two");
        run("two streams", List.of(a1, b2, a3),
                () -> mergeStreams(List.of(List.of(a1, a3), List.of(b2))));
        run("empty stream", List.of(a1), () -> mergeStreams(List.of(List.of(), List.of(a1))));
        run("tie", List.of(new LogEntry(1, "a", "x"), new LogEntry(1, "b", "x")),
                () -> mergeStreams(List.of(List.of(new LogEntry(1, "b", "x")),
                        List.of(new LogEntry(1, "a", "x")))));
        run("single", List.of(a1, a3), () -> mergeStreams(List.of(List.of(a1, a3))));
        run("no streams", List.of(), () -> mergeStreams(List.of()));
    }

    private static void run(String name, Object expected, Supplier<Object> attempt) {
        try {
            Object actual = attempt.get();
            System.out.printf("%s %s expected=%s actual=%s%n",
                    Objects.deepEquals(expected, actual) ? "PASS" : "FAIL", name, expected, actual);
        } catch (UnsupportedOperationException e) {
            System.out.printf("FAIL %s expected=%s actual=TODO%n", name, expected);
        }
    }
}

