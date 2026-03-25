import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> baseMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(baseMap.containsKey(key)) {
                baseMap.put(key, baseMap.get(key) + 1);
            }
            else baseMap.put(key, 1);
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int key : list) {
            sb.append(baseMap.getOrDefault(key, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
