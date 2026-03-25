import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int basketNum = s.nextInt(), playNum = s.nextInt();
        int[] basket = new int[basketNum];
        int[] newBasket = new int[basketNum];


        for (int i = 0; i < basketNum; i++) {
            basket[i] = i + 1;
        }



        for (int i = 0; i < playNum; i++) {
            int j = s.nextInt(), k = s.nextInt();

            for (int l = 0; l < basket.length; l++) {
                newBasket[l] = basket[l];
            }

            for (int l = 0; l <= k - j; l++) {
                basket[j - 1 + l] = newBasket[k - 1 - l];
            }
        }

        for (int i = 0; i < basket.length; i++) {
            System.out.print(basket[i] + " ");
        }

    }
}
