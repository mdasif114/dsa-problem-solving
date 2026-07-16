import java.util.*;
import java.util.function.Supplier;

/**
 * P29 - Bounded Event Buffer
 * Evidence: Representative | Probability: Medium | Difficulty: Medium
 * Simulate OFFER(value) and POLL operations on a FIFO buffer. OFFER returns
 * "ACCEPTED" or "REJECTED" when full; POLL returns the value or "EMPTY".
 */
public class P29_BoundedEventBuffer_Starter {
    public record Operation(String type, String value) {
        static Operation offer(String value) { return new Operation("OFFER", value); }
        static Operation poll() { return new Operation("POLL", ""); }
    }

    public static List<String> process(List<Operation> operations, int capacity) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("fifo", List.of("ACCEPTED", "ACCEPTED", "a", "b"), () -> process(List.of(
                Operation.offer("a"), Operation.offer("b"), Operation.poll(), Operation.poll()), 2));
        run("full", List.of("ACCEPTED", "REJECTED"), () -> process(List.of(
                Operation.offer("a"), Operation.offer("b")), 1));
        run("empty poll", List.of("EMPTY"), () -> process(List.of(Operation.poll()), 2));
        run("space reused", List.of("ACCEPTED", "a", "ACCEPTED", "b"), () -> process(List.of(
                Operation.offer("a"), Operation.poll(), Operation.offer("b"), Operation.poll()), 1));
        run("no operations", List.of(), () -> process(List.of(), 2));
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

