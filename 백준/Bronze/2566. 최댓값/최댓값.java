import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] A = new int[9][9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                A[i][j] = s.nextInt();
            }
        }
        int max = A[0][0];
        int[] maxIndex = {1, 1};

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(max < A[i][j]) {
                    max = A[i][j];
                    maxIndex[0] = i + 1;
                    maxIndex[1] = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(maxIndex[0] + " " + maxIndex[1]);
    }
}