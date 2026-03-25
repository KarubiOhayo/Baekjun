import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        System.out.println(findMinBags(n));
    }

    static int findMinBags (int n) {
        int count5 = 0;
        int count3 = 0;

        while(n > 0) {
            if(n >= 5 && n % 5 == 0) {
                n -= 5;
                count5++;
            } else {
                n -= 3;
                count3++;
            }
        }
        if(n < 0) return -1;
        return count5 +  count3;
    }
}