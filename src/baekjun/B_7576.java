package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 골드5 7576 - 토마토
// BFS, 격자 그래프, 최단거리
public class B_7576 {

  static boolean[][] visited;
  static int[][] depth;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static List<int[]> starts = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] arr = new int[m][n];
    boolean existZero = false;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if (arr[i][j] == 0) {
          existZero = true;
        }
        if (arr[i][j] == 1) {
          starts.add(new int[]{i, j});
        }
      }
    }
    if (!existZero) {
      System.out.println(0);
      return;
    }

    visited = new boolean[m][n];
    depth = new int[m][n];
    bfs(arr);

    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && arr[i][j] == 0) {
          System.out.println(-1);
          return;
        }
        if (depth[i][j] > max) {
          max = depth[i][j];
        }
      }
    }

    System.out.println(max);

  }

  static void bfs(int[][] arr) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();

    for (int[] start : starts) {
      queue.offer(start);
      visited[start[0]][start[1]] = true;
      depth[start[0]][start[1]] = 0;
    }

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      for (int i = 0; i < dx.length; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length || arr[nx][ny] == -1) {
          continue;
        }
        if (visited[nx][ny]) {
          continue;
        }

        depth[nx][ny] = depth[cur[0]][cur[1]] + 1;
        queue.offer(new int[]{nx, ny});
        visited[nx][ny] = true;
      }
    }
  }
}
