import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nArray = new int[10];
        int same;

        ArrayList<Integer> searchArray = new ArrayList<>();




        for (int i = 0; i < 10; i++) {
            nArray[i] = s.nextInt() % 42;
        }
        searchArray.add(nArray[0]);

        for (int i = 1; i < 10; i++) {
            boolean isDuplicate = false;

            for (int value : searchArray) {
                if (value == nArray[i]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                searchArray.add(nArray[i]);
            }
        }

        System.out.println(searchArray.size());
    }
}
