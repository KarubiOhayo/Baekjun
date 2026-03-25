import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int comNum = Integer.parseInt(br.readLine());
        int linkNum = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < comNum; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < linkNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int comp1 = Integer.parseInt(st.nextToken());
            int comp2 = Integer.parseInt(st.nextToken());

            setGraph(graph, comp1, comp2);
        }

        System.out.println(BFS(graph, 1));
    }

    static int BFS(ArrayList<ArrayList<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            for (Integer i : graph.get(queue.poll() - 1)) {
                if(!visited.contains(i)) {
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
        return visited.size() - 1;
    }

    static void setGraph(ArrayList<ArrayList<Integer>> graph, int comp1, int comp2) {
        graph.get(comp1 - 1).add(comp2);
        graph.get(comp2 - 1).add(comp1);
    }
}