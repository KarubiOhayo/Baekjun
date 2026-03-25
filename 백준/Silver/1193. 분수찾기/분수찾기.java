import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int floor = 1;

        while((floor * (floor + 1)) / 2 < N) {
            floor++;
        }
        int son = (floor - (((floor * (floor + 1)) / 2) - N)), mom = ((((floor * (floor + 1)) / 2) - N) + 1);

        if(floor % 2 == 0) {
            System.out.println(son + "/" + mom);
        }
        else {
            System.out.println(mom + "/" + son);
        }
    }
}