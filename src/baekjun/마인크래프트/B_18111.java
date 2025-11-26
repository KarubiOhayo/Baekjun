package baekjun.마인크래프트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 실버2 마인크래프트
// 2025.11.26
public class B_18111 {
	/*
	 * a는 세로 N, 가로 M 크기의 집터를 골랐다.
	 * 집터 맨 왼쪽 위의 좌표는 (0, 0)이다.
	 * 목적은 이 집터 내의 땅 높이를 일정하게 바꾸는 것이다.
	 *
	 * 여기서 다음과 같은 두 작업을 할 수 있다.
	 * 1. 좌표(i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
	 * 2. 인벤토리에서 블록 하나를 꺼내 좌표(i, j)의 가장 위에 있는 블록 위에 놓는다.
	 * 1번 작업은 2초, 2번 작업은 1초가 걸린다.
	 * 평탄화 작업에 걸리는 최소 시간과 평탄화 후 땅의 높이를 출력하시오
	 * 작업을 시작할 때 인벤토리에는 B개의 블록이 들어 있다.
	 * 땅의 최대 높이는 256이며 음수가 될 수 없다.
	 *
	 * 첫째 줄에 N, M, B가 주어진다(1 <= N, M <= 500 | 0 <= B <= 6.4 * 10^7)
	 * 둘째 줄 부터 N개의 줄에 각각 M개의 정수로 땅의 높이가 주어진다.
	 * 땅의 높이는 256보다 작거나 같은 자연수 또는 0이다.
	 *
	 * 땅을 고르는 데 걸리는 시간과 땅의 높이를 출력하라.
	 * 답이 여러개라면 그 중 땅의 높이가 가장 높은 것을 출력하라.
	 */
	/*
	 * 일단 현재 가진 블록으로 평탄화가 가능한지 판별한다.
	 * 2차원 배열 map의 모든 값을 더한 값이 좌표의 수로 나누어 떨어지는지?
	 * 일단 2차원 배열이 아니어도 된다.
	 * 떨어지지 않는다면 그 나머지 값이 현재 인벤토리의 블록 수보다 큰지 작은지 판별해야 한다.
	 * 그러니까 (채울 때) 필요한 블록 수가 모자라다면 - 무조건 빼야 한다.
	 * 블록 수가 충분하다면 - 빼는게 빠른지, 채우는 게 빠른지 판별해야 한다.
	 * 빼는건 2초, 채우는건 1초가 걸린다.
	 */
	/*
	 * 시간에 대한 최적값을 찾는것이지, 블럭 놓는 횟수가 제일 적은 걸 찾는게 아니다.
	 * 다시 처음부터, 빼는 건 2초, 더하는건 1초.
	 * 그럼 최소 높이부터 최대 높이까지 전부 평탄화 후 가장 빨리 완성된 것의 시간과 높이를 찾는다.
	 *
	 * 리스트를 정렬해서 getFirst()부터 getLast() 까지 반복함(각 높이별 시간을 구한다)
	 * 근데 어차피 높이 범위는 0부터 256까지이고, 반복 횟수에 크게 차이가 없음
	 * 오히려 리스트 정렬 과정에서 시간을 많이 쓰게 됨
	 *
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		List<Integer> map = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map.add(Integer.parseInt(st.nextToken()));
			}
		}
		int time = Integer.MAX_VALUE;
		int height = 0;
		int block = map.stream().mapToInt(x -> x).sum() + B;

		for (int i = 0; i <= 256; i++) {
			int temp = 0;
			if ((i * map.size()) > block) {
				continue;
			}
			for (Integer integer : map) {
				if (integer < i) {
					temp += i - integer;
				}
				if (integer > i) {
					temp += (integer - i) * 2;
				}
			}
			if (temp <= time) {
				time = temp;
				height = i;
			}
		}

		System.out.println(time + " " + height);
	}
}
