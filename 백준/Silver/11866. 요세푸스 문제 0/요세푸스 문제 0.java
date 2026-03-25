import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> people = IntStream.range(1, n + 1)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        StringBuilder sb = new StringBuilder();
        List<String> s = new ArrayList<>();

        int i = k - 1;
        while (!people.isEmpty()) {
            if(i >= people.size()) i %= people.size();
            s.add(people.remove(i).toString());

            i += (k-1);
        }
        sb.append("<").append(String.join(", ",  s)).append(">");
        System.out.println(sb);
    }
}
