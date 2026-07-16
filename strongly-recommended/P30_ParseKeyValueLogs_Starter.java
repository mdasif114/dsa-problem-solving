import java.util.*;
import java.util.function.Supplier;

/**
 * P30 - Parse Key-Value Logs
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Parse space-separated key=value fields. Values may be double-quoted and contain
 * spaces; backslash escapes the next character inside quotes. Reject malformed
 * input by returning an empty map. Later duplicate keys overwrite earlier ones.
 */
public class P30_ParseKeyValueLogs_Starter {
    public static Map<String, String> parseFields(String line) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("simple", Map.of("service", "api", "status", "500"),
                () -> parseFields("service=api status=500"));
        run("quoted", Map.of("message", "disk full", "host", "h1"),
                () -> parseFields("message=\"disk full\" host=h1"));
        run("escaped quote", Map.of("message", "say \"hi\""),
                () -> parseFields("message=\"say \\\"hi\\\"\""));
        run("duplicate", Map.of("a", "2"), () -> parseFields("a=1 a=2"));
        run("malformed quote", Map.of(), () -> parseFields("a=\"open"));
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

