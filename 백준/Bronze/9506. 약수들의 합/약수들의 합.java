import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while(true) {
            int n = s.nextInt();
            ArrayList<Integer> factors = new ArrayList<>();
            if(n == -1) break;

            for (int i = 1; i < n; i++) {
                if(n % i == 0) factors.add(i);
            }
            int sum = factors.stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            ArrayList<String> factorsToString = factors.stream()
                    .map(String::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));

            if (sum == n) {
                String result = String.join(" + ", factorsToString);
                System.out.printf("%d = ", n);
                System.out.println(result);
            }
            else System.out.printf("%d is NOT perfect.\n", n);
        }
    }
}