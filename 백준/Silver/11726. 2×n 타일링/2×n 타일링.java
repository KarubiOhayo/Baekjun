import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        System.out.println(getResult(n));
    }

    static long getResult(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        if(n == 1) return 1;
        dp[2] = 2;
        if(n == 2) return 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % 10007L + dp[i - 2] % 10007L;
            dp[i] %= 10007L;
        }

        return dp[n];
    }
}
