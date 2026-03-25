import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(), m = s.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = s.nextInt();
        }
        List<Integer> combines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if(cards[i] + cards[j] + cards[k] <= m) {
                        combines.add(cards[i] + cards[j] + cards[k]);
                    }
                }
            }
        }
        /*
        n장의 카드 중 세 장을 뽑는다.
        그 세 장의 합 중 m을 넘지 않는 조합을 찾는다.
        그 중 가장 큰 합을 가진 조합을 출력한다.
         */
        System.out.println(Collections.max(combines));
    }
}
