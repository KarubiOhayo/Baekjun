import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        System.out.println(getResult(n));
        /*
        2*n 크기의 직사각형을 2*1, 1*2 크기의 직사각형으로 채우는 방법의 수
        1 1
        2 2
        3 3
        4 5
        5 8
        6 13
        7 21
        8 34
        9 55
         */
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
