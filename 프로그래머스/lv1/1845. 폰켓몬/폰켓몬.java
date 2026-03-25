import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> typeOfMon = new HashSet<>();
        
        for(int num : nums) {
            typeOfMon.add(num);
        }
        
        if(nums.length/2 > typeOfMon.size()) answer = typeOfMon.size();
        else answer = nums.length/2;
        
        return answer;
    }
}