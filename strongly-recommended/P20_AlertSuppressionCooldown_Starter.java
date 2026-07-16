import java.util.*;
import java.util.function.Supplier;

/**
 * P20 - Alert-Suppression Cooldown
 * Evidence: Representative | Probability: High | Difficulty: Medium
 * Alerts are timestamp ordered. Emit an alert unless the same key was emitted
 * within cooldownSeconds. An alert exactly cooldownSeconds later is allowed.
 */
public class P20_AlertSuppressionCooldown_Starter {
    public record Alert(String key, long timestamp) {}

    public static List<Alert> emittedAlerts(List<Alert> alerts, long cooldownSeconds) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Alert a0 = new Alert("cpu", 0);
        Alert a5 = new Alert("cpu", 5);
        Alert a10 = new Alert("cpu", 10);
        run("suppressed", List.of(a0), () -> emittedAlerts(List.of(a0, a5), 10));
        run("boundary allowed", List.of(a0, a10), () -> emittedAlerts(List.of(a0, a10), 10));
        run("different keys", List.of(a0, new Alert("disk", 1)),
                () -> emittedAlerts(List.of(a0, new Alert("disk", 1)), 10));
        run("later after suppressed", List.of(a0, new Alert("cpu", 11)),
                () -> emittedAlerts(List.of(a0, a5, new Alert("cpu", 11)), 10));
        run("empty", List.of(), () -> emittedAlerts(List.of(), 10));
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

