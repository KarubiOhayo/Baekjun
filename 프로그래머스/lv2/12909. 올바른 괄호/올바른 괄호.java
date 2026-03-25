import java.util.*;
/*
스택에 (가 나오면 넣고, )가 나오면 pop 한다.
스택이 비어있는데 )가 나오거나, 루프가 끝났는데 스택이 비어있지 않다면 false

*/
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() && s.charAt(i) == ')') {
                return false;
            }
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                stack.pop();
            }
        }
        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}