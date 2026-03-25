import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int searchPrimeNumber(List<Integer> numbers) {
        int count = 0;

        for (int num: numbers) {
            List<Integer> divisors = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                if(num % i == 0) divisors.add(i);
            }
            if(divisors.size() == 2) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(s.nextInt());
        }
        System.out.println(searchPrimeNumber(numbers));
    }
}
