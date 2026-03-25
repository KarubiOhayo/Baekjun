import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(getFact(n));
    }

    static int getFact (int n) {
        long result = 1;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            result *= i;

            while (result % 10 == 0) {
                result /= 10;
                count++;
            }
            result %= 1000;
        }
        return count;
    }
}
