import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testSize = s.nextInt();

        for (int i = 0; i < testSize; i++) {
            String st = s.next();
            System.out.print(st.charAt(0));
            System.out.print(st.charAt(st.length() - 1));
            System.out.println();
        }
    }
}
