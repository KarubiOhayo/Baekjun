import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testNum = s.nextInt();
        int[] coins = {25, 10, 5, 1};

        for (int i = 0; i < testNum; i++) {
            int[] coinsCount = {0, 0, 0, 0};
            int totalCoins = s.nextInt();
            int o = 0;

            while(totalCoins > 0) {
                coinsCount[o] = totalCoins / coins[o];
                totalCoins = totalCoins - (coins[o] * (totalCoins / coins[o]));
                o++;
            }

            for (int k : coinsCount) {
                System.out.print(k + " ");
            }
            
            System.out.println();
        }
    }
}