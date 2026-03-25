import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int M = 1234567891;

    static long power (int r, int i) {
        long result = 1;

        for (int j = 0; j < i; j++) {
            result = (result * r) % M;
        }

        return  result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = 31;

        int n = Integer.parseInt(br.readLine());
        String hashSt = br.readLine();
        char[] chars = hashSt.toCharArray();
        long[] hashNums = new long[n];

        for (int i = 0; i < n; i++) {
            hashNums[i] = chars[i] - 'a' + 1;
        }


        long hash = 0;
        for (int i = 0; i < n; i++) {
            hash += (hashNums[i] * power(r, i)) % M;
            hash %= M;
        }
        System.out.println(hash);
    }
}
