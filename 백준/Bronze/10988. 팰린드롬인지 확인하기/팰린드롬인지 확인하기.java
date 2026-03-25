import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String st = s.next();
        String reverseSt = new StringBuilder(st).reverse().toString();

        if(reverseSt.equals(st)){
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }

        System.out.println();

    }
}
