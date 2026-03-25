import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());
        int[] ages = new int[n];
        String[] names = new String[n];
        Map<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ages[i] = Integer.parseInt(st.nextToken());
            names[i] = st.nextToken();
        }
        for (int i = 0; i < n; i++) {
            if(map.get(ages[i]) == null) {
                map.put(ages[i], new ArrayList<>());
            }
            map.get(ages[i]).add(names[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int key : map.keySet()) {
            for (int i = 0; i < map.get(key).size(); i++) {
                sb.append(key).append(" ").append(map.get(key).get(i)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
