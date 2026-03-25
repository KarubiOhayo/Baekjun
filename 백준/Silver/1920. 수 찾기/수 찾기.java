import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<Integer> baseSet = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        int m =  Integer.parseInt(br.readLine());
        String nums = br.readLine();

        int[] checkNums = Arrays.stream(nums.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if(baseSet.contains(checkNums[i])) {
                sb.append(1).append("\n");
            }
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
