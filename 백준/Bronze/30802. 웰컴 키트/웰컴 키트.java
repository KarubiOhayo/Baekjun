import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String sizesSt = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] sizes = Arrays.stream(sizesSt.split(" ")).mapToInt(Integer::parseInt).toArray();

        int totalT = 0;
        for (int size : sizes) {
            totalT += (int) Math.ceil((double) size / T);
        }
        System.out.println(totalT);
        System.out.println(n/P + " " + n%P);
    }
}
