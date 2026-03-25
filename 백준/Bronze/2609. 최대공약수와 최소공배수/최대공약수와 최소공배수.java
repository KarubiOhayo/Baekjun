import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> n0 = new ArrayList<>();
        List<Integer> m0 = new ArrayList<>();
        List<Integer> divisors = new ArrayList<>();
        List<Integer> n1 = new ArrayList<>();
        List<Integer> m1 = new ArrayList<>();
        List<Integer> multiples = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            if(n%i == 0) {
                n0.add(i);
            }
        }

        for (int i = m; i > 0; i--) {
            if(m%i == 0) {
                m0.add(i);
            }
        }

        for (int i = 0; i < n0.size(); i++) {
            for (int j = 0; j < m0.size(); j++) {
                if (Objects.equals(m0.get(j), n0.get(i))) {
                    divisors.add(n0.get(i));
                }
            }
        }

        int temp = 1;
        while(true) {
            n1.add(temp*n);

            if(temp >= m) break;
            temp++;
        }
        temp = 1;
        while(true) {
            m1.add(temp*m);

            if(temp >= n) break;
            temp++;
        }
        for (int i = 0; i < n1.size(); i++) {
            for (int j = 0; j < m1.size(); j++) {
                if (Objects.equals(n1.get(i), m1.get(j))) {
                    multiples.add(m1.get(j));
                }
            }
        }
        int maxDivisors = divisors.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
        int minMultiples = multiples.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();

        System.out.println(maxDivisors);
        System.out.println(minMultiples);
    }
}
