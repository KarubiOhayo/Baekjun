import java.util.*;

class Solution {
    static int count = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        adventure(k, dungeons, 0);
        return count;
    }
    
    public void adventure(int k, int[][] dungeons, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (k < dungeons[i][0] || k < dungeons[i][1]) continue;
            
            int curDepth = depth + 1;
            count = Math.max(count, curDepth);
            visited[i] = true;
            adventure(k - dungeons[i][1], dungeons, curDepth);
            visited[i] = false;
        }
        
        return;
    }
}