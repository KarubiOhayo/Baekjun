import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double[] testScores = new double[n];
        double newAverage = 0;

        for (int i = 0; i < n; i++) {
            testScores[i] = s.nextInt();
        }

        double max = testScores[0];

        for (int i = 1; i < n; i++) {
            if(max < testScores[i]) {
                max = testScores[i];
            }
        }

        for (int i = 0; i < n; i++) {
            testScores[i] = testScores[i] / max * 100;
        }

        for (int i = 0; i < n; i++) {
            newAverage += testScores[i];
        }

        System.out.println(newAverage/n);
    }
}
