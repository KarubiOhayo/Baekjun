import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        int size = friends.length;
        for (int i = 0; i < size; i++) {
            map.put(friends[i], i);
        }
        
        int[][] graph = new int[size][size];
        int[] giftIndex = new int[size];
        
        for (int i = 0; i < gifts.length; i++) {
            String[] temp = gifts[i].split(" ");
            graph[map.get(temp[0])][map.get(temp[1])]++;
            giftIndex[map.get(temp[0])]++;
            giftIndex[map.get(temp[1])]--;
        }
        
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (graph[i][j] == graph[j][i]) {
                    if (giftIndex[i] == giftIndex[j]) continue;
                    if (giftIndex[i] > giftIndex[j]) result[i]++;
                    else result[j]++;
                    continue;
                }
                if (graph[i][j] > graph[j][i]) result[i]++;
                else result[j]++;
            }
        }
        for (int num: result) {
            if (answer < num) {
                answer = num;
            }
        }
    
        return answer;
    }
}