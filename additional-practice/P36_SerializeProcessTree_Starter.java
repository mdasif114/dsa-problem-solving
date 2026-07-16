import java.util.*;
import java.util.function.Supplier;

/**
 * P36 - Serialise and Deserialise a Process Tree
 * Evidence: Representative | Probability: Lower | Difficulty: Medium
 * Input format is preorder with comma-separated integer IDs and '#' null markers.
 * Parse and serialise it back to a canonical identical representation. Return an
 * empty string for malformed input. IDs may be negative.
 */
public class P36_SerializeProcessTree_Starter {
    public static String canonicalRoundTrip(String serialized) {
        // TODO: deserialize to a tree, then serialize it; do not merely echo input.
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", "1,2,#,#,3,#,#", () -> canonicalRoundTrip("1,2,#,#,3,#,#"));
        run("single", "9,#,#", () -> canonicalRoundTrip("9,#,#"));
        run("negative", "-1,#,#", () -> canonicalRoundTrip("-1,#,#"));
        run("empty tree", "#", () -> canonicalRoundTrip("#"));
        run("malformed", "", () -> canonicalRoundTrip("1,#"));
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

