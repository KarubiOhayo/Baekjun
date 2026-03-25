import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String[] nums = ((a*b*c)+"").split("");

        for (int i = 0; i < 10; i++) {
            String num = i+"";
            System.out.println(Arrays.stream(nums)
                    .filter(s -> s.equals(num))
                    .count());
        }
    }
}
