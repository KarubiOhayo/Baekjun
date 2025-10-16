package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 실버3 11727 - 2*n 타일링 2
// 2025 10 16
public class B_11727 {

  static int[] dp;
  static int num = 10007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    System.out.println(dp(n));

  }

  static int dp(int n) {
    dp = new int[n + 3];
    dp[1] = 1;
    dp[2] = 3;
    dp[3] = 5;
    /* gpt 힌트
    좋아, **최소 힌트(#1)**만! 😊

    오른쪽(또는 왼쪽)에서부터 마지막에 놓는 블록만 생각해봐.
        한 칸(세로 1열)만 차지하는 경우와 **두 칸(세로 2열)**을 한꺼번에 채우는 경우가 있어.
        두 칸을 채울 땐 방법이 둘이야:
        (1) 가로 1×2 두 개로 채우기, (2) 정사각형 2×2 한 개로 채우기.
        이 관찰로 “직전 상태들”과의 관계(점화식)를 만들 수 있어.
        답은 10007로 나눈 나머지를 출력해야 해.
        더 원하면 “다음 힌트”!
        */
    /*
    위 힌트를 바탕으로 문제를 해석 해 보면, 맨 오른쪽의 마지막 블록에 따라
    한 칸일때 n-1번째의 총합
    두 칸일때 n-2번째의 총합
    그러니까 dp[n] = dp[n-1] + dp[n-2] + dp[n-2]가 된다.
     */

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 2];
      dp[i] %= num;
    }
    return dp[n];
  }
}
