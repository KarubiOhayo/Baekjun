import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;

        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            String st = n + "";
            int[] ints = Arrays.stream(st.split("")).mapToInt(Integer::parseInt).toArray();
            int[] ints2 = ints.clone();

            for (int i = 0; i < ints.length; i++) {
                ints[i] = ints2[ints.length - 1 - i];
            }

            StringBuilder sb = new StringBuilder();
            for (int anInt : ints) {
                sb.append(anInt);
            }
            
            String stR =  sb.toString();
            if(st.equals(stR)) System.out.println("yes");
            else  System.out.println("no");
        }
    }
}
