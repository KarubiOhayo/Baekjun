package baekjun.최대_힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// 백준 실버2 최대 힙
// 2025.11.26
/*
 * 배열에 자연수 x를 넣는다.
 * 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
 * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
 *
 * 첫 줄에 연산의 개수 N(1 <= N <= 100,000)이 주어진다.
 * 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
 * x가 자연수라면 배열에 x라는 값을 넣는 연산이고, 0이라면 배열에서 가장 큰 앖을 출력하고 그 값을 배열에서 제거하는 경우이다.
 * x는 2^31보다 작다.
 *
 */
public class B_11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x > 0) {
				q.add(x);
			} else {
				if (q.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(q.poll()).append('\n');
				}
			}
		}

		System.out.println(sb);
	}
}
