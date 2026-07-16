import java.util.*;
import java.util.function.Supplier;

/**
 * P01 - Top Error-Producing Services
 * Evidence: Representative | Probability: High | Difficulty: Medium
 * Parse valid "timestamp service severity message" lines. Return up to k service
 * names ordered by descending ERROR count, then ascending service name.
 * Ignore malformed lines. Constraints: up to 1,000,000 lines; k may be zero.
 * Clarify: token grammar, case sensitivity, malformed lines, ties, and k bounds.
 */
public class P01_TopErrorProducingServices_Starter {
    public static List<String> topErrorServices(List<String> logLines, int k) {
        // TODO: implement without embedding expected test values.
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", List.of("payments", "orders"), () -> topErrorServices(List.of(
                "2026-07-16T10:00:00Z payments ERROR timeout",
                "2026-07-16T10:00:01Z search INFO healthy",
                "2026-07-16T10:00:02Z payments ERROR retry failed",
                "2026-07-16T10:00:03Z orders ERROR unavailable"), 2));
        run("tie", List.of("api", "web"), () -> topErrorServices(List.of(
                "t1 web ERROR x", "t2 api ERROR y"), 2));
        run("malformed ignored", List.of("api"), () -> topErrorServices(List.of(
                "bad", "t1 api ERROR x", "t2 api INFO ok"), 3));
        run("no errors", List.of(), () -> topErrorServices(List.of("t1 api INFO ok"), 2));
        run("zero k", List.of(), () -> topErrorServices(List.of("t1 api ERROR x"), 0));
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

