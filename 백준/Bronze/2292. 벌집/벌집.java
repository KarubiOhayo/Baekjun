import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int floor = 1;

        while((1 + (floor - 1) * 3 * floor) < N) {
            floor++;
        }

        System.out.println(floor);
    }
}