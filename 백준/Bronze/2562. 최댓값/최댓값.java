import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nArray = new int[9];


        for (int i = 0; i < 9; i++) {
            nArray[i] = s.nextInt();
        }

        int max = nArray[0];
        int count = 0;


        for (int i = 0; i < 9; i++) {

            if(max < nArray[i]) {
                max = nArray[i];
            }
        }
        while(max != nArray[count]) {
            count++;
        }

        System.out.println(max + "\n" + (count + 1));
    }
}
