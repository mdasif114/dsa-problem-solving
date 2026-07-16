import java.util.*;
import java.util.function.Supplier;

/**
 * P37 - Flood-Fill Network Zone
 * Evidence: Recurring | Probability: Medium | Difficulty: Medium
 * Starting at row,column, replace the connected 4-directional region's old zone
 * value with newZone. Return a new grid and do not mutate the input.
 */
public class P37_FloodFillNetworkZone_Starter {
    public static int[][] floodFill(int[][] zones, int row, int column, int newZone) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", new int[][]{{2, 2, 0}, {2, 0, 1}},
                () -> floodFill(new int[][]{{1, 1, 0}, {1, 0, 1}}, 0, 0, 2));
        run("same value", new int[][]{{1}}, () -> floodFill(new int[][]{{1}}, 0, 0, 1));
        run("single", new int[][]{{9}}, () -> floodFill(new int[][]{{1}}, 0, 0, 9));
        run("diagonal excluded", new int[][]{{2, 0}, {0, 1}},
                () -> floodFill(new int[][]{{1, 0}, {0, 1}}, 0, 0, 2));
        run("empty", new int[][]{}, () -> floodFill(new int[][]{}, 0, 0, 2));
    }

    private static void run(String name, Object expected, Supplier<Object> attempt) {
        try {
            Object actual = attempt.get();
            boolean pass = Objects.deepEquals(expected, actual);
            System.out.printf("%s %s expected=%s actual=%s%n", pass ? "PASS" : "FAIL",
                    name, show(expected), show(actual));
        } catch (UnsupportedOperationException e) {
            System.out.printf("FAIL %s expected=%s actual=TODO%n", name, show(expected));
        }
    }

    private static String show(Object value) {
        return value instanceof Object[] array ? Arrays.deepToString(array) : String.valueOf(value);
    }
}

