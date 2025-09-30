package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(oneTwoThree(n)).append("\n");
        }
        System.out.println(sb);

        /*
        n을 1, 2, 3의 합으로 나타내는 방법의 수를 구한다.
        f(1) = 1
        f(2) = 2
        f(3) = 4
        f(4) = 7
        f(5) = 13
        f(6) = 24
        f(7) = 44
        f(8) = 81
        f(9) = 149
        f(10) = 274
        1은 1
        1
        2는 2
        1 1
        2
        3은 4
        1 1 1
        1 2
        2 1
        3
         */
    }

    static int oneTwoThree(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if(n == 1) return 1;
        dp[1] = 2;
        if(n == 2) return 2;
        dp[2] = 4;
        if(n == 3) return 4;

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n - 1];
    }
}
