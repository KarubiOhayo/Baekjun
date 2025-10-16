package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2579 계단 오르기
// DP
public class B_2579_GPT {

  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    dp = new int[n + 1];
    int[] stairs = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }

    System.out.println(dp(stairs));

  }

  static int dp(int[] stairs) {
    dp[1] = stairs[1];
    dp[2] = stairs[1] + stairs[2];
    dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
    for (int i = 4; i < dp.length; i++) {
      dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
    }

    return dp[stairs.length - 1];
  }
}
