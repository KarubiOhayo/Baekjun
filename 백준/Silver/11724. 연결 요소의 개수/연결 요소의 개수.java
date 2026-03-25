import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

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
      if (!visited[i]) {
        count++;
        dfs(i, graph);
      }
    }

    System.out.println(count);
  }

  public static void dfs(int v, List<List<Integer>> graph) {
    if (visited[v]) {
      return;
    }
    visited[v] = true;
    for (int w : graph.get(v)) {
      if (!visited[w]) {
        dfs(w, graph);
      }
    }
  }

}