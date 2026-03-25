import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();
        int[] nArray = new int[n];
        int save = 0;

        for (int i = 0; i < n; i++) {
            nArray[i] = i + 1;
        }

        for (int l = 0; l < m; l++) {
            int i = s.nextInt(), j = s.nextInt();

            for (int o = 0; o < n; o++) {

                if (o == i - 1) {
                    save = nArray[o];
                    nArray[o] = nArray[j - 1];
                }
                if (o == j - 1) {
                    nArray[j - 1] = save;
                }
            }
        }




        for (int l = 0; l < n; l++) {
            System.out.print(nArray[l] + " ");
        }
    }
}
