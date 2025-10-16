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
    StringBuilder sb2 = new StringBuilder();
    for (int i = 0; i < T; i++) {
      Map<String, List<String>> map = new HashMap<>();
      // List가 아니라 value의 갯수만 세는 형식
      Map<String, Integer> test = new HashMap<>();

      int N = Integer.parseInt(br.readLine());
      for (int j = 0; j < N; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String value = st.nextToken();
        String key = st.nextToken();

        test.put(key, test.getOrDefault(key, 0) + 1);

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

      int testAns = 1;
      for (Integer value : test.values()) {
        testAns *= value + 1;
      }
      sb2.append(testAns - 1).append('\n');
    }
    System.out.println(sb);
    System.out.println(sb2);
  }

}
