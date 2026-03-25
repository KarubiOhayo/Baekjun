import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0];
                int y = cur[1];
                x += dx[i];
                y += dy[i];
                if (x < 0 || y < 0 || x >= n || y >= m) continue;
                if (visited[x][y] || maps[x][y] == 0) continue;
                
                q.offer(new int[]{x, y});
                visited[x][y] = true;
                maps[x][y] = maps[cur[0]][cur[1]] + 1;
            }
        }
        if (!visited[n - 1][m - 1]) return - 1;
        return maps[n - 1][m - 1];
    }
}