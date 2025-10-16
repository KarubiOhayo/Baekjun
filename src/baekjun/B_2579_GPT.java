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
      /*
       각 계단 별 최댓값 구하는 문제
       1층에선 1
       2층에선 1층 + 2층
       3층에선 1층, 2층 중 큰 값 + 3층
       4층부터는? max(전전층까지의 총합값, 전전전층까지 총합값 + 전층 값) + i층
       왜 이렇게 하느냐?
       3번 연속으로 밟을 수 없는데
       전전층 총합 + i층 하면 한칸 띄우고 더하기
       전전전층 총합 + 전층 + i층 하면 두칸 연속으로 더하기
       */
    }

    return dp[stairs.length - 1];
  }
}
