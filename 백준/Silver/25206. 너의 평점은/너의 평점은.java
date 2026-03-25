import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double totalScore = 0, totalCredit = 0;

        String[] gradeList = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        double[] gradeScore = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, -1};

        ArrayList<String> name = new ArrayList<>();
        ArrayList<Double> credit = new ArrayList<>();
        ArrayList<String> grade = new ArrayList<>();
        ArrayList<Double> score = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            name.add(s.next());
            credit.add(s.nextDouble());
            grade.add(s.next());
            score.add(0.0);
        }

        for (int i = 0; i < gradeList.length; i++) {
            for (int j = 0; j < grade.size(); j++) {
                if(gradeList[i].equals(grade.get(j))) {
                    score.set(j, gradeScore[i]);
                }
            }
        }

        for (int i = 0; i < 20; i++) {
            if(score.get(i) != -1.0) {
                totalScore += credit.get(i) * score.get(i);
                totalCredit += credit.get(i);
            }
        }

        System.out.println(totalScore/totalCredit);
    }
}