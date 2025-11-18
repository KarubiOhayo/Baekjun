package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2579번 계단 오르기 복습
// 정답 2025.11.18
public class B_2579_Retry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[n + 1];
		dp[1] = arr[1];
		if (arr.length > 2) dp[2] = dp[1] + arr[2];
		if (arr.length > 3) dp[3] = Math.max(arr[2] + arr[3], dp[1] + arr[3]);

		if (arr.length > 4) {
			for (int i = 4; i <= n; i++) {
				dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
			}
		}
		System.out.println(dp[n]);
	}
}
