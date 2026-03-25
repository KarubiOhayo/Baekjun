import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> dice = new ArrayList<>();

        dice.add(s.nextInt());
        dice.add(s.nextInt());
        dice.add(s.nextInt());
        int max = dice.get(0);
        int found = 0;
        boolean error = true;

        for (int i = 0; i < dice.size(); i++) {
            if(dice.get(i) < 1 || dice.get(i) > 6){
                error = false;
            }
        }

        for (int i = 0; i < dice.size(); i++) {
            if(max < dice.get(i)){
                max = dice.get(i);
            }
        }
        for (int i = 0; i < dice.size() - 1; i++) {
            int check = 0;
            if(dice.get(0) == dice.get(i + 1)) {
                found++;
                check++;
                max = dice.get(i+1);
            }
            if(dice.get(i) == dice.get(i + 1) && check == 0) {
                found++;
                max = dice.get(i+1);
            }
        }

        if(error) {
            switch (found) {
                case 0:
                    System.out.println(max * 100);
                    break;
                case 1:
                    System.out.println(1000 + max * 100);
                    break;
                case 2:
                    System.out.println(10000 + max * 1000);
                    break;
            }
        }


    }
}
