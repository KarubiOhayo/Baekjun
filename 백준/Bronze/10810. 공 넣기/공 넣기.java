import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();
        int[] nArray = new int[n];
        //int i = 0, j = 0, k = 0;

        for (int l = 0; l < m; l++) {          //m번 입력받기
            int i = s.nextInt(), j = s.nextInt(), k = s.nextInt();

            for (int o = 0; o < n; o++) {         //i번부터 j번까지 k번의 공 넣기
                if (o >= i - 1 && o <= j - 1) {
                    nArray[o] = k;
                }
            }
        }




        for (int l = 0; l < n; l++) {
            System.out.print(nArray[l]);
            if (l != n - 1) {
                System.out.print(" ");
            }
        }
    }
}
