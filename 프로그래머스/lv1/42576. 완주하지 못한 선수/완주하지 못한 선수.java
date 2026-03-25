import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])) {
                map.put(participant[i], map.get(participant[i]) + 1);
            } else map.put(participant[i], 1);
        }
        
        for(String com : completion) {
            map.put(com, map.get(com) - 1);
        }
        
        String answer = "";
        
        for(String key : map.keySet()) {
            if(map.get(key) == 1) answer = key;
        }
        
        
        return answer;
    }
}