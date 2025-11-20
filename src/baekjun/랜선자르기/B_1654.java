package baekjun.랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2025.11.20
// 이분 탐색, 매개변수 탐색
/*
 * N개의 랜선을 만들어야 한다.
 * K개의 랜선은 이미 가지고 있지만 길이가 제각각이다.
 * 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶다.
 * 이미 자른 랜선은 다시 붙일 수 없으며, 자르거나 만들 때 손실되는 길이는 없다.
 * N개의 랜선은 무조건 만들 수 있으며, 이 때 만들 수 있는 랜선의 최대 길이를 구하라
 */
public class B_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long[] lines = new long[K];

		for (int i = 0; i < K; i++) {
			lines[i] = Long.parseLong(br.readLine());
		}

		/*
		 * 랜선의 최대 길이는 랜선의 총 길이를 N으로 나눈 값보다 클 수 없다
		 * 이분 탐색으로 찾을 수 있다.
		 */
		long start = 1L;
		long end = Arrays.stream(lines).sum() / N;
		long mid = (start + end) / 2;

		while (start <= end) {
			long count = 0;
			for (long line : lines) {
				count += line / mid;
			}

			if (count >= N) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = (start + end) / 2;
		}

		System.out.println(mid);
	}
}
