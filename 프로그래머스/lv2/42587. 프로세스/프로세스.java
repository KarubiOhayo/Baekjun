import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            boolean temp = true;
            
            for(int[] i: q) {
                if (i[0] > curr[0]) {
                    q.offer(curr);
                    temp = false;
                    break;
                }
            }
            if(temp) {
                answer++;
                if(curr[1] == location) {
                    return answer;
                }
            }
        }
        
        return answer;
    }
}