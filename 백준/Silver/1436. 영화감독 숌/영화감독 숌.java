import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        System.out.println(find666(n));
    }
    static int find666(int n) {
        int count = 0;
        int result = 666;

        while (true) {
            if((result+"").contains("666")) {
                count++;
            }
            if(count == n) break;
            result++;
        }
        return result;
    }
}