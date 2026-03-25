import java.util.*;
/*
 컴퓨터의 개수 n
 computers는 연결에 대한 정보가 담김
 i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j] == 1
 컴퓨터는 0번부터 n-1번까지
 computer[i][j] == 1이면 computers[j][i]도 1이다.
 
 2차원 배열 그래프 computers[][]가 주어졌다.
 정점의 수 n이 주어졌다.
 
 bfs를 n번 반복해서 돌리는데, 시작 지점 i가 방문 처리 되지 않은 경우에만
 bfs가 돌아간 횟수 = 네트워크의 수
*/

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    static void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 0; i < computers[cur].length; i++) {
                if (computers[cur][i] == 0) continue;
                if (visited[i]) continue;
                int next = i;
                visited[i] = true;
                q.offer(i);
            }
            
        }
    }
}