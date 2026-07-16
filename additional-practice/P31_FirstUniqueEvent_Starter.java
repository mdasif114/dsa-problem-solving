import java.util.*;
import java.util.function.Supplier;

/**
 * P31 - First Unique Event
 * Evidence: Recurring | Probability: Medium | Difficulty: Easy
 * Return the first event name whose total frequency is one, or null when none.
 * Input order defines "first".
 */
public class P31_FirstUniqueEvent_Starter {
    public static String firstUnique(List<String> events) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("middle", "b", () -> firstUnique(List.of("a", "b", "a", "c", "c")));
        run("first", "a", () -> firstUnique(List.of("a", "b", "b")));
        run("none", null, () -> firstUnique(List.of("a", "a")));
        run("single", "x", () -> firstUnique(List.of("x")));
        run("empty", null, () -> firstUnique(List.of()));
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

