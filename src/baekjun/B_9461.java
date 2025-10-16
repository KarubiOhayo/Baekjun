package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 실버3 9461 - 파도반 수열
// DP
public class B_9461 {

  static long[] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      sb.append(dp(N)).append("\n");
    }
    System.out.println(sb);
  }

  static long dp(int N) {
    dp = new long[N + 6];
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    dp[5] = 2;

    for (int i = 6; i <= N; i++) {
      dp[i] = dp[i - 1] + dp[i - 5];
    }
    return dp[N];
  }
}
