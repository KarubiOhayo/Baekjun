import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new TreeSet<>();
        Set<String> set2 = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            set2.add(br.readLine());
        }
        TreeSet<String> intersection = new TreeSet<>(set);
        intersection.retainAll(set2);

        StringBuilder sb = new StringBuilder();
        sb.append(intersection.size()).append("\n");

        for (String s : intersection) {
            sb.append(s).append("\n");
        }
        
        System.out.println(sb);
    }
}
