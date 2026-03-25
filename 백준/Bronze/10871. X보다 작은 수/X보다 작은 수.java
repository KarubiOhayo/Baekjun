import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), x = s.nextInt();
        int[] nArray = new int[n];

        for (int i = 0; i < n; i++) {
            nArray[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {

            if(nArray[i] < x) {
                System.out.print(nArray[i] + " ");
            }

        }
    }
}
