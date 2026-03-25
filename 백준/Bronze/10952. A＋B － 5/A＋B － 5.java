import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean exit = true;

        while(exit) {
            int a = s.nextInt(), b = s.nextInt();

            if(a == 0 && b == 0) {
                exit = false;
            }
            else {
                System.out.println(a + b);
            }
        }

    }
}
