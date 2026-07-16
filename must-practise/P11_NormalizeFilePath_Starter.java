import java.util.*;
import java.util.function.Supplier;

/**
 * P11 - Normalise Unix File Path
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Canonicalise an absolute Unix path: collapse repeated '/', remove '.', and
 * resolve '..' without moving above root. Return '/' for an empty canonical path.
 */
public class P11_NormalizeFilePath_Starter {
    public static String normalizePath(String path) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", "/a/c", () -> normalizePath("/a/b/../c"));
        run("repeated separators", "/a/b", () -> normalizePath("//a///b/"));
        run("above root", "/a", () -> normalizePath("/../../a"));
        run("current directory", "/", () -> normalizePath("/./"));
        run("root", "/", () -> normalizePath("/"));
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

