import java.util.*;
import java.util.function.Supplier;

/**
 * P24 - Prefix Configuration Lookup
 * Evidence: Representative | Probability: Medium | Difficulty: Medium
 * Given prefix -> value entries, return the value for the longest prefix of key.
 * Return null when no prefix matches. Empty-string prefix is a valid default.
 */
public class P24_PrefixConfigLookup_Starter {
    public static String longestPrefixValue(Map<String, String> config, String key) {
        // TODO: implement with a trie, then discuss a direct-map alternative.
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<String, String> config = Map.of("", "default", "api.", "api", "api.pay.", "pay");
        run("longest", "pay", () -> longestPrefixValue(config, "api.pay.timeout"));
        run("shorter", "api", () -> longestPrefixValue(config, "api.search"));
        run("default", "default", () -> longestPrefixValue(config, "web.home"));
        run("exact", "api", () -> longestPrefixValue(config, "api."));
        run("no match", null, () -> longestPrefixValue(Map.of("x", "one"), "abc"));
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

