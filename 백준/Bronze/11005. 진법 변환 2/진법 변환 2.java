import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int B = s.nextInt();
        ArrayList<Character> finalResult = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        while(N > 0) {
            int a = N % B;
            N /= B;

            result.add(a);
        }

        for (int i = result.size() - 1; i >= 0; i--) {
            if(result.get(i) < 10) {
                finalResult.add((char) ('0' + result.get(i)));
            }
            else {
                finalResult.add((char) ('A' + result.get(i) - 10));
            }
        }
        char[] test = new char[finalResult.size()];

        for (Character character : finalResult) {
            System.out.print(character);
        }
    }
}