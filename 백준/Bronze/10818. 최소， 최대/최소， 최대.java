import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nArray = new int[n];


        for (int i = 0; i < n; i++) {
            nArray[i] = s.nextInt();
        }

        int max = nArray[0];
        int min = nArray[0];

        for (int i = 0; i < n; i++) {

            if(max < nArray[i]) {
                max = nArray[i];
            }
            if(min > nArray[i]) {
                min = nArray[i];
            }

        }

        System.out.println(min + " " + max);
    }
}
