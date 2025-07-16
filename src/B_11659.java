import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] sumArr = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sumArr[i] = num + sumArr[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            long result = 0;
            result = sumArr[j] - sumArr[i - 1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
