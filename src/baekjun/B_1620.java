package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 백준 실버 4 1620 - 나는야 포켓몬 마스터 이다솜
// 자료구조, 집합과 맵, 해시
public class B_1620 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Map<String, String> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      map.put((i + 1) + "", str);
      map.put(str, (i + 1) + "");
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String str = br.readLine();
      if (map.containsKey(str)) {
        sb.append(map.get(str)).append("\n");
      }
    }
    System.out.println(sb);

  }

}
