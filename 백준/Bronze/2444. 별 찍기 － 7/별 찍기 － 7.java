import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int starNum = s.nextInt();

        for (int i = 1; i <= starNum * 2 - 1; i++) {
            if(i > starNum) {
                for (int j = starNum; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = ((starNum * 2 - 1) - i) * 2; j >= 0 ; j--) {
                    System.out.print("*");
                }
            }
            else {
                for (int j = starNum - i - 1; j >= 0; j--) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i * 2 - 1; j++) {
                    System.out.print("*");
                }
            }


            System.out.println();
        }
    }
}
