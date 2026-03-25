import java.util.Scanner;

public class Main {
    static int isPrime(int num) {
        if(num < 2) return 0;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return 0;
        }
        return num;
    }
    static int sumPrimeNumbers(int m, int n) {
        int sum = 0;

        for (int i = m; i <= n; i++) {
            sum += isPrime(i);
        }

        if(sum < 1) return -1;

        return sum;
    }

    static int minPrimeNumbers (int m, int n) {

        if(sumPrimeNumbers(m, n) != -1) {
            for (int i = m; i <= n; i++) {
                if(isPrime(i) != 0) return isPrime(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int m = s.nextInt(), n = s.nextInt();

        System.out.println(sumPrimeNumbers(m, n));
        if(sumPrimeNumbers(m, n) != -1) {
            System.out.println(minPrimeNumbers(m, n));
        }
    }
}