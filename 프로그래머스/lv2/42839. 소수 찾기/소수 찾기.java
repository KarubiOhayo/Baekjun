import java.util.*;

class Solution {
    
    static Set<Integer> numSet = new HashSet<>();
    
    public int solution(String numbers) {
        List<Character> chars = new ArrayList<>();
        
        for (int i = 0; i < numbers.length(); i++) {
            chars.add(numbers.charAt(i));
        }
        
        buildNum("", chars);
        System.out.println(numSet);
        
        return numSet.size();
    }
    
    public void buildNum(String num, List<Character> chars) {
        
        if (!num.isBlank()) {
            System.out.println(num);
            int temp = Integer.parseInt(num);
            if (isPrime(temp)) numSet.add(temp);
        }
        
        if (chars.isEmpty()) return;
        
        for (int i = 0; i < chars.size(); i++) {
            String newNum = num + chars.get(i);
            List<Character> newChar = new ArrayList<>(chars);
            newChar.remove(i);
            buildNum(newNum, newChar);
        }
    }
    
    public boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}