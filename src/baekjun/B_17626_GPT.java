package baekjun;

// 백준 실버3 17626 - Four Squares
// 2025.11.18

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현할 수 있다.
 * 26은 5^2과 1^2의 합이다.
 * 또는 4^2 + 3^2 + 1^2 로도 표현할 수 있다.
 * 자연수 n이 주어질 때, n을 최소 개수의 제곱수 합으로 표현하라
 * 1 <= n <= 50,000
 */
public class B_17626_GPT {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			// dp[i]를 i로 초기화 한다.
			dp[i] = i;
			// dp[0]은 0 이고, i가 제곱수라면 dp[i - square]는 1이 된다.
			// dp[i]는 하나의 제곱수 + 최적해의 조합으로 이루어진다.
			// 모든 제곱수를 하나씩 빼 보는 방식으로 답을 구한다.
			// 예를 들어 50 이라고 하면, (1, 4, 9, 16, 25, 36, 49) + dp[i - (i보다 작은 제곱수)] 이런 식이다.
			for (int j = 1; j * j <= i; j++) {
				int square = j * j;
				dp[i] = Math.min(dp[i], dp[i - square] + 1);
			}
		}

		System.out.println(dp[n]);
	}
}
