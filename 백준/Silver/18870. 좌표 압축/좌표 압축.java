import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());

        int[] x0 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayList<Integer> sortedList = Arrays.stream(x0)
                .distinct()
                .sorted()
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < sortedList.size(); i++) {
            valueToIndex.put(sortedList.get(i), i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(valueToIndex.get(x0[i])).append(" ");
        }
        System.out.println(sb);
    }
}
