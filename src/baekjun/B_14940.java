package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 백준 실버1 쉬운 최단거리
// 그래프 탐색, BFS, 격자 그래프
// 2025 10 14
public class B_14940 {

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int n, m, ix, iy;
  static int[][] result;

  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if (arr[i][j] == 2) { // 목표지점의 인덱스
          ix = i;
          iy = j;
        }
      }
    }
    visited = new boolean[n][m];
    result = arr;

    bfs(arr);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j]) {
          result[i][j] *= -1;
        }
        sb.append(result[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static void bfs(int[][] arr) {
    ArrayDeque<int[]> q = new ArrayDeque<>();

    visited[ix][iy] = true;
    q.offer(new int[]{ix, iy});
    result[ix][iy] = 0;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || arr[nx][ny] == 0) {
          continue;
        }
        visited[nx][ny] = true;
        q.offer(new int[]{nx, ny});
        result[nx][ny] = result[cur[0]][cur[1]] + 1;
      }
    }

  }
}
