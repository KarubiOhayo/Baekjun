import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            if(x < w) {
                x = w;
            }
            if(y < h) {
                y = h;
            }
        }
        
        return x * y;
    }
}