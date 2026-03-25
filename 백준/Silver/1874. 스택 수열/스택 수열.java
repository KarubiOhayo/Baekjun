import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int num = 1;
        boolean isPossible = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while (num <= target) {
                stack.push(num);
                num++;
                sb.append("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                isPossible = false;
                break;
            }
        }

        if (isPossible) System.out.println(sb);
        else System.out.println("NO");
    }
}
