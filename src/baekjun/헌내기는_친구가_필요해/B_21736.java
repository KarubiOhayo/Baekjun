package baekjun.헌내기는_친구가_필요해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 실버2 헌내기는 친구가 필요해
// 2025.11.27
public class B_21736 {
	/*
	 * 캠퍼스의 크기 N * M
	 * 캡퍼스에서 이동하는 방법은 벽이 아닌 상하좌우로
	 * 첫째 줄에 캠퍼스의 크기 N, M이 주어짐
	 * 둘째 줄 부터 N개 줄에는 캠퍼스 정보가 주어짐
	 * O는 빈 공간, X는 벽, I는 도연이(시작 노드), P는 사람(목적지)
	 * 도연이가 만날 수 있는 사람의 수 출력
	 * 아무도 만나지 못한 경우 TT 출력
	 */
	static char[][] campus;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		campus = new char[N][M];
		visited = new boolean[N][M];
		int x = 0, y = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				campus[i][j] = line.charAt(j);
				if (campus[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}

		int result = bfs(campus, x, y);
		if (result == 0) {
			System.out.println("TT");
		} else {
			System.out.println(result);
		}
	}

	static int bfs(char[][] campus, int x, int y) {
		Queue<int[]> q =  new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;

		int count = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (visited[nx][ny] || campus[nx][ny] == 'X') continue;
				if (campus[nx][ny] == 'P') count++;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}

		return count;
	}
}
