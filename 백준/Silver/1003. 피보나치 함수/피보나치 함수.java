import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int fibonacci(int n) {
        if (n <= 1) return n;
        else {
            int result = 0;
            int iterA = 0, iterB = 1;

            for (int i = 2; i <= n; i++) {
                result = iterA + iterB;
                iterA = iterB;
                iterB = result;
            }

            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                sb.append(1).append(" ").append(0).append("\n");
            } else if (n == 1) {
                sb.append(0).append(" ").append(1).append("\n");
            } else sb.append(fibonacci(n - 1)).append(" ").append(fibonacci(n)).append("\n");
        }
        System.out.println(sb);
    }
}
