import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        List<String> list = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(list);
        
        list.forEach(System.out::println);
        
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1).startsWith(list.get(i))) {
                return false;
            }
        }
        
        return answer;
    }
}