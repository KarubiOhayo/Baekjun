package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 실버2 연결 요소의 개수
// 그래프 탐색
// 2025 10 13
public class B_11724_review {

  static List<List<Integer>> graph;
  static boolean[] visited;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    visited = new boolean[N + 1];

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph.get(x).add(y);
      graph.get(y).add(x);
    }

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) { // dfs로 한번 쭉 돌고 방문처리한 노드는 스킵 후 미방문 정점 나오면 또 쭉 돌고 반복
        count++;
        dfs(i, graph);
      }
    }

    System.out.println(count);
  }

  public static void dfs(int v, List<List<Integer>> graph) {
    if (visited[v]) { // 방문처리한 노드 나오면 리턴
      return;
    }
    visited[v] = true;
    for (int w : graph.get(v)) { // 1 -> 2, 5 이런 식으로 되어있다면 2랑 5 둘다 방문
      if (!visited[w]) { // w(v에 연결된 노드)
        dfs(w, graph); // 다시 w에 연결된 노드 탐색
      }
    }
  }

}
