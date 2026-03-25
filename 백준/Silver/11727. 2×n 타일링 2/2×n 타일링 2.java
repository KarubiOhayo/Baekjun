import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

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
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 2];
      dp[i] %= num;
    }
    return dp[n];
  }
}
