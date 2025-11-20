package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 실버2 1260번 DFS와 BFS
// 2025.11.20
public class B_1260 {
	static int N;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for (List<Integer> integers : graph) {
			Collections.sort(integers);
		}
		visited = new boolean[N + 1];
		dfs(V, graph);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(V, graph);

	}

	static void dfs(int v, List<List<Integer>> graph) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int node : graph.get(v)) {
			if (!visited[node]) {
				dfs(node, graph);
			}
		}
	}

	static void bfs(int v, List<List<Integer>> graph) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int next : graph.get(cur)) {
				if (visited[next]) {
					continue;
				}
				visited[next] = true;
				q.offer(next);
			}
		}
	}
}
