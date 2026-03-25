import java.util.*;
/*
다리의 길이 = 트럭이 올라갈 수 있는 최대 수 제한이면서 다리를 건너는데 필요한 최소 시간임
일단 트럭 최소 1대는 다리에 올라갈 수 있음
큐가 필요함. 다리를 건너고 있는 트럭들을 담는 큐
큐에 트럭이 들어가면 현재 weight를 증가, 큐에서 빠지면 감소시키면서 한계 중량을 체크함.


*/
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        LinkedList<int[]> onBridge = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();
        
        for (int i: truck_weights) {
            truck.offer(i);
        }
        
        onBridge.add(new int[]{truck.peek(), 0});
        int currWeight = truck.poll();
        
        while (!onBridge.isEmpty()) {
            if (onBridge.getFirst()[1] >= bridge_length) {
                currWeight -= onBridge.getFirst()[0];
                onBridge.removeFirst();
            }
            if (!truck.isEmpty() && (currWeight + truck.peek()) <= weight) {
                onBridge.addLast(new int[]{truck.peek(), 0});
                currWeight += truck.poll();
            }
            
            for(int[] trucks: onBridge) {
                trucks[1]++;
            }
            
            answer++;
        }
        
        
        return answer;
    }
}