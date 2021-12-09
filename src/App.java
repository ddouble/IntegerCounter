import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 10, 8};
        int lessThan = 5;
        int greaterThan = 7;

        int[] result = countElements(arr, lessThan, greaterThan);
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("  ")));
        System.out.printf("%d numbers of less than %d\n", result[0], lessThan);
        System.out.printf("%d numbers of less than %d\n", result[1], greaterThan);

    }

    private static int[] countElements(int[] arr, int lessThan, int greaterThan) {
        int[] result = new int[]{0, 0};
        for (int v : arr) {
            if (v < lessThan) {
                result[0]++;
            }
            if (v > greaterThan) {
                result[1]++;
            }
        }
        return result;
    }
}
