import java.util.*;
/*
두 개의 단어 begin, target과 단어의 집합 words가 있음
begin에서 target으로 변환하는 가장 짧은 과정을 찾아야 함
한 번에 한 개의 알파벳만 바꿀 수 있고, words에 있는 단어로만 변환할 수 있음

words는 각각 어떤 노드를 나타냄
서로 알파벳이 하나씩만 다른 노드는 서로 연결되어 있음

1. begin을 노드 목록에 넣어야 함
2. target이 words에 있는지 확인해야 함(없다면 return 0)
3. 위 규칙을 기반으로 그래프를 만들어야 함
4. begin을 시작 지점으로 그래프 탐색을 했을 때, target이 방문 처리 되었는지 확인해야 함 
(방문하지 않았다면 return 0)
5. 그래프 탐색을 끝냈다면 target의 depth가 답

*/
class Solution {
    static boolean[] visited;
    static int[] depth;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<List<String>> graph2 = new ArrayList<>();
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int targetNode = 0;
        
        for (int i = 0; i <= words.length + 1; i++) {
            graph.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }
        
        visited = new boolean[graph.size()];
        depth = new int[graph.size()];
        
        List<String> nodes = new ArrayList<>();
        nodes.add(begin);
        
        for (int i = 0; i < words.length; i++) {
            nodes.add(words[i]);
            if (words[i].equals(target)) {
                targetNode = i + 2;
            }
        }
        
        // if (targetNode == 0) return 0;
        
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                int diffCount = 0;
                for (int k = 0; k < begin.length(); k++) {
                    if (i == j) continue;
                    if (nodes.get(i).charAt(k) != nodes.get(j).charAt(k)) diffCount++;
                    if (diffCount > 1) break;
                }
                if (diffCount == 1) {
                    graph.get(i + 1).add(j + 1);
                    graph2.get(i + 1).add(nodes.get(j));
                }
            }
        }
        
        for(int i = 0; i < graph.size(); i++) {
            System.out.println(i + " " + graph.get(i));
        }
        System.out.println("===========================");
        for(int i = 0; i < graph.size(); i++) {
            System.out.println(i + " " + graph2.get(i));
        }
        
        // System.out.println(targetNode);
        
        bfs(targetNode);
        if (!visited[targetNode]) return 0;
        
        return depth[targetNode];
    }
    
    public void bfs(int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        depth[1] = 0;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            for (int next: graph.get(curr)) {
                if (visited[next]) continue;
                
                visited[next] = true;
                depth[next] = depth[curr] + 1;
                if (next == target) return;
                q.offer(next);
            }
        }
    }
}