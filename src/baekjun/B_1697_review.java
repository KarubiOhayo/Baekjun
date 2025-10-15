package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1697 숨바꼭질
// 2025 10 13
public class B_1697_review {
  static int N;
  static int K;
  private static final int MAX = 100000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    if (K <= N) {
      System.out.println(N - K);
      return;
    }
    System.out.println(bfs(N, K));


    /*
     * N이 K에 도달하기 위한 최단 횟수 찾기
     * N은 -1, +1, *2만 가능하다.
     * K가 N보다 작다면 답은 N - K
     * 그렇지 않다면?
     * 그래프를 만든다.
     * N에 대해서 -1, +1, *2 세 가지 선택지가 주어지고
     * 또 그 각 세개에 대해서 -1, +1, *2 세 가지 선택지가 주어진다(트리)
     */
  }

  public static int bfs(int start, int target) {
    boolean[] visited = new boolean[MAX];
    int[] dist = new int[MAX + 1];

    Queue<Integer> q = new LinkedList<>();
    q.offer(start);
    visited[start] = true;
    dist[start] = 0;
    while (!q.isEmpty()) {
      int current = q.poll();
      if (current == target) {
        return dist[current];
      }
      int[] nexts = {current - 1, current + 1, current * 2};
      for (int next : nexts) {
        if (next < 0 || next > MAX) {
          continue;
        }
        if (visited[next]) {
          continue;
        }
        visited[next] = true;
        dist[next] = dist[current] + 1;
        q.offer(next);
      }

    }

    return -1;
  }

}