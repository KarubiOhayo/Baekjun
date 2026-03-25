import java.io.*;
import java.util.*;

public class Main {
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
				mid = (start + end) / 2;
			} else {
				end = mid - 1;
				mid = (start + end) / 2;
			}
		}

		System.out.println(mid);
	}
}