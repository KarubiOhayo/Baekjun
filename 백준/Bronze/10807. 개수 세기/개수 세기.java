import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nArray = new int[n];

        for (int i = 0; i < n; i++) {
            nArray[i] = s.nextInt();
        }
        int v = s.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {

            if(nArray[i] == v) {
                count++;
            }

        }
        System.out.println(count);
    }
}
