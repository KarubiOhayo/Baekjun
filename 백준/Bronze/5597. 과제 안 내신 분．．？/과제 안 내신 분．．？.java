import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nArray = new int[30];
        int[] nArrayB = new int[2];
        int o = 0;



        for (int i = 0; i < 30; i++) {
            nArray[i] = i + 1;
        }


        for (int i = 0; i < 28; i++) {
            int k = s.nextInt();
            for (int j = 0; j < 30; j++) {
                if(nArray[j] == k) {
                    nArray[j] = 0;
                }
            }
        }

        for (int i = 0; i < 30; i++) {
            if (nArray[i] != 0) {
                nArrayB[o] = nArray[i];
                o++;
            }
        }
        System.out.println(Math.min(nArrayB[0], nArrayB[1]));
        System.out.println(Math.max(nArrayB[0], nArrayB[1]));

    }
}
