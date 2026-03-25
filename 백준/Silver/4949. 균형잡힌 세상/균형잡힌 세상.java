import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;
            if(isBalanced(line)) {
                System.out.println("yes");
            }
            else System.out.println("no");
        }
    }

    static boolean isBalanced(String line) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            } else if (c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
