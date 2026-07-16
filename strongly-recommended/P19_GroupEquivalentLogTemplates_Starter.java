import java.util.*;
import java.util.function.Supplier;

/**
 * P19 - Group Equivalent Log Templates
 * Evidence: Representative | Probability: Medium | Difficulty: Medium
 * Replace every whitespace-delimited token consisting only of digits with "#",
 * then count canonical templates. Whitespace is normalised to one space.
 */
public class P19_GroupEquivalentLogTemplates_Starter {
    public static Map<String, Integer> groupTemplates(List<String> logs) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("numeric IDs", Map.of("user # failed", 2), () -> groupTemplates(List.of(
                "user 12 failed", "user 99 failed")));
        run("different", Map.of("status ok", 1, "status bad", 1),
                () -> groupTemplates(List.of("status ok", "status bad")));
        run("whitespace", Map.of("job # done", 2), () -> groupTemplates(List.of(
                "job   1 done", "job 2 done")));
        run("numeric only", Map.of("#", 2), () -> groupTemplates(List.of("1", "22")));
        run("empty", Map.of(), () -> groupTemplates(List.of()));
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

