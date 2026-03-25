import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> times = Arrays.stream(Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray())
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        int totalTime = 0;

        for (int i = 0; i < times.size(); i++) {
            totalTime += times.get(i) * (times.size() - i);
        }
        
        System.out.println(totalTime);
    }
}
