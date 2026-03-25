import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            String value = clothes[i][0];
            
            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(value);
            }
        }
        for(String key: map.keySet()) {
            answer *= map.get(key).size() + 1;
        }
        
        return answer - 1;
    }
}