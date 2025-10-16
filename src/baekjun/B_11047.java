package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 실버4 11047 - 동전 0
// 그리디 알고리즘
public class B_11047 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] coins = new int[n];

    for (int i = n - 1; i >= 0; i--) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (coins[i] > k) {
        continue;
      }
      count += k / coins[i];
      k %= coins[i];
    }
    System.out.println(count);
  }

}
