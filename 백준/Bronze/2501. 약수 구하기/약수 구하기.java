import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt(), K = s.nextInt();

        ArrayList<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if(N % i == 0) {
                factors.add(i);
            }
        }
        if(K <= factors.size()) {
            System.out.println(factors.get(K - 1));
        }
        else {
            System.out.println(0);
        }
    }
}