package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 백준 실버3 9375 - 패션왕 신해빈
// 수학, 자료구조, 조합론, 해시맵
public class B_9375 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      Map<String, List<String>> map = new HashMap<>();
      int N = Integer.parseInt(br.readLine());
      for (int j = 0; j < N; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String value = st.nextToken();
        String key = st.nextToken();
        if (!map.containsKey(key)) {
          map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);

      }
      int ans = 1;
      for (String s : map.keySet()) {
        ans *= map.get(s).size() + 1;
      }
      sb.append(ans - 1).append('\n');
    }
    System.out.println(sb);
  }

}
