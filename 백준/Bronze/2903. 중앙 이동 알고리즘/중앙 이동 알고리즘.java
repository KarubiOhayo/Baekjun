import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int testNum = s.nextInt();
        int primalDot = 2;
        
        for (int i = 0; i < testNum; i++) {
            primalDot = (primalDot * 2) - 1;
        }

        System.out.println(primalDot * primalDot);
    }
}