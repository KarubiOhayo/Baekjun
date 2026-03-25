import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);

        int a = s.nextInt() , b = s.nextInt(), c = s.nextInt();

        System.out.println(triangle(a, b, c));

    }

    static String triangle(int a, int b, int c) {
        if(a + b + c != 180) return "Error";
        if(a == 60 && b == 60) return "Equilateral";
        if((a == b && b != c) || (b == c && a != c) || (a == c && b != c) ) return "Isosceles";
        if(a != b && b != c && a != c) return "Scalene";
        return "";
    }
}