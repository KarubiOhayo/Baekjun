package programers;

import java.util.*;

public class Solution_42578 {
  public int solution(String[][] clothes) {
    int answer = 1;

    Map<String, Set<String>> map = new HashMap<>();
    for(int i = 0; i < clothes.length; i++) {
      String key = clothes[i][1];
      String value = clothes[i][0];
      // map.putIfAbsent(key, new ArrayList<>()); // 실전에선 쓰기 힘들지도
      // map.get(key).add(value);
      if (map.containsKey(key)) {
        map.get(key).add(value);
      } else {
        map.put(key, new HashSet<>()); // Set이든 List든 별 상관 없는 케이스
        map.get(key).add(value);
      }
    }
    int cursor = map.size();

    for (String key: map.keySet()) {
      answer *= map.get(key).size() + 1;
    }


    return answer - 1;
  }
}
