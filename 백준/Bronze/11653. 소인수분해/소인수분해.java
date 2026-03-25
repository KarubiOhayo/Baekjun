import java.util.Scanner;


public class Main {
    static boolean isPrime(int num) {
        if(num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    static void searchPrimeFactors (int n) {
        int i = 2;
        while (true) {
            if(n % i == 0 && n != 2){
                System.out.println(i);
                n /= i;
                i = 2;
            }
            else i++;
            if(isPrime(n)){
                System.out.println(n);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        if(n > 1) searchPrimeFactors(n);
    }
}