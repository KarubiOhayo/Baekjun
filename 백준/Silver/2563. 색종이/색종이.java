import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] whitePaper = new int[100][100];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                whitePaper[i][j] = 0;
            }
        }

        int blackNum = s.nextInt();
        for (int i = 0; i < blackNum; i++) {
            int a = s.nextInt(), b = s.nextInt();
            for (int j = a; j < a + 10; j++) {
                for (int k = b; k < b +10; k++) {
                    whitePaper[j][k] = 1;
                }
            }
        }

        int blackArea = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(whitePaper[i][j] == 1) {
                    blackArea++;
                }
            }
        }

        System.out.println(blackArea);
    }
}