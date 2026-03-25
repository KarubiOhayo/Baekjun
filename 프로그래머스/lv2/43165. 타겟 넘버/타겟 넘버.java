import java.util.*;

class Solution {
    static int[] A;
    static int T;
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        A = numbers;
        T = target;
        dfs(0, 0);
        
        return count;
    }
    
    public static void dfs(int i, int sum) {
        if(i == A.length) {
            if (sum == T) {
                count++;
            }
            return;
        }
        
        dfs(i + 1, sum + A[i]);
        dfs(i + 1, sum - A[i]);
    }
}