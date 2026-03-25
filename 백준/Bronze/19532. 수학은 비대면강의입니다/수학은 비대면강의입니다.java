import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt(), b = s.nextInt(), c = s.nextInt(),
                d = s.nextInt(), e = s.nextInt(), f = s.nextInt();

        int x = -999, y = -999;

        for (int i = x; i <= 999; i++) {
            for (int j = y; j <= 999; j++) {
                if(a*i+b*j==c && d*i+e*j==f){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        System.out.printf("%d %d\n", x, y);
    }
}