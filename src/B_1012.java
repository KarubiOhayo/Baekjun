import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1012 {

  static int[][] grid;
  // 4방향 탐색
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static int n, m;
  static boolean[][] visited;

  public static int countComponents(int[][] field) {
    // grid 초기화
    grid = field;

    // 반복 횟수 지정을 위한 변수 초기화
    n = grid.length;
    m = grid[0].length;

    // 방문 여부 (실제 배열과 연동) 초기화
    visited = new boolean[n][m];

    int count = 0;
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < m; y++) {
        // 그래프가 채워져 있으면서 방문하지 않았을 때만 bfs 실행 후 카운트
        if (grid[x][y] == 1 && !visited[x][y]) {
          bfs(x, y);
          count++;
        }
      }
    }
    return count;
  }

  public static void bfs(int sx, int sy) {
    // bfs를 위한 배열 큐 선언
    ArrayDeque<int[]> queue = new ArrayDeque<>();

    // countComponent에서 받은 최초 좌표 방문 처리 및 큐에 넣기
    visited[sx][sy] = true;
    queue.offer(new int[]{sx, sy});

    // 큐가 빈다면 탐색 완료
    while (!queue.isEmpty()) {
      // 큐에서 꺼내온 배열 사용해서 xy좌표 설정
      int[] cur = queue.poll();
      int x = cur[0];
      int y = cur[1];

      //좌표 하나에 대해 4방향 탐색
      for (int dir = 0; dir < 4; dir++) {
        // dir이 0일때 dx는 -1, dy는 0이므로 왼쪽
        // 0, 1, 2, 3 각각 왼쪽, 오른쪽, 위, 아래를 가리키게 됨
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // nx/ny(인접 좌표)가 배열의 범위를 넘어서면 끊고 반복문 다시 시작
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }
        // 인접 좌표가 이미 방문한 곳이면 끊고 반복문 다시 시작
        if (visited[nx][ny]) {
          continue;
        }
        // 인접 좌표가 비어있으면 다시 시작
        if (grid[nx][ny] != 1) {
          continue;
        }

        // 위 조건을 전부 뚫었다면 해당 인접 좌표를 방문처리 후 큐에 넣음
        visited[nx][ny] = true;
        queue.offer(new int[]{nx, ny});
      }
    }
  }

  // 메인에선 배열 초기화 후 메소드에 값 삽입만 담당
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int[][] field = new int[n][m];

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
