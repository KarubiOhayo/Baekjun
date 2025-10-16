package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 백준 17219 - 비밀번호 찾기
// 자료구조, 해시맵
public class B_17219 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Map<String, String> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      map.put(st.nextToken(), st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      sb.append(map.get(br.readLine())).append('\n');
    }

    System.out.println(sb);
  }

}
