import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int[][] grid;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int n, m;
  static boolean[][] visited;

  public static int countComponents(int[][] field) {
    grid = field;
    n = grid.length;
    m = grid[0].length;
    visited = new boolean[n][m];

    int count = 0;
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < m; y++) {
        if (grid[x][y] == 1 && !visited[x][y]) {
          bfs(x, y);
          count++;
        }
      }
    }
    return count;
  }

  public static void bfs(int sx, int sy) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    visited[sx][sy] = true;
    queue.offer(new int[]{sx, sy});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0];
      int y = cur[1];

      for (int dir = 0; dir < 4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if(visited[nx][ny]) continue;
        if(grid[nx][ny] != 1) continue;
        visited[nx][ny] = true;
        queue.offer(new int[]{nx, ny});
      }
    }
  }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] field =  new int[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

          System.out.println(countComponents(field));
        }
    }
}
