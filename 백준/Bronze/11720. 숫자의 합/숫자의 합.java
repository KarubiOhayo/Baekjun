import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testNum = s.nextInt();
        String st = s.next();

        int sum = 0;

        for (int i = 0; i < st.length(); i++) {
            sum += (st.charAt(i) - 48);
        }

        System.out.println(sum);
    }
}
