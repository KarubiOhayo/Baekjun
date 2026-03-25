import java.util.*;

/*
일단 progresses[i]에서 speeds[i]를 몇번(time) 더해야 100 이상이 되는지 측정한다.
pro를 전부 큐에 넣고, 한 번씩 speeds를 더한다.
맨 앞에 있는 녀석이 100을 넘겼다면, 100을 넘기지 않은 녀석이 나올 때 까지 poll 하고 count에 값을 더한 뒤, 다음으로 넘어간다.
*/
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            int temp = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                temp++;
            }
            q.offer(temp);
        }
        
        int temp = 1;
        int first = q.poll();
        for(int i = 0; i < progresses.length - 1; i++) {
            if (first >= q.peek()) {
                temp++;
                q.poll();
            } else {
                answerList.add(temp);
                temp = 1;
                first = q.poll();
            }
            if (q.isEmpty()) {
                answerList.add(temp);
            }
        }
        
        return answerList;
    }
}