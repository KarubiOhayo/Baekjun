package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2606 {
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
        /*
        웜 바이러스
        1번 컴퓨터가 기준이다.
        집합 하나를 만들어서
        뒤에 입력받은 둘 중 하나가 기존 집합에 포함되면 나머지 하나도 집합에 넣는다.
        아니라면 무시한다.
        집합의 크기를 출력한다.
        이런 방식으로는 곤란할지도
        왜냠은?
        연결이 나중에 될 수도 있기 때문에
        예를들면
        1 3 이 나오기 전에
        3 5가 먼저 나왔는데
        나중에 1 3이 나와버리면 틀려벌임
         */
    }

    static int BFS(ArrayList<ArrayList<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            for (Integer i : graph.get(queue.poll() - 1)) {
                if (!visited.contains(i)) {
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }

        System.out.println(visited);
        return visited.size() - 1;
    }

    static void setGraph(ArrayList<ArrayList<Integer>> graph, int comp1, int comp2) {
        graph.get(comp1 - 1).add(comp2);
        graph.get(comp2 - 1).add(comp1);
    }
}
