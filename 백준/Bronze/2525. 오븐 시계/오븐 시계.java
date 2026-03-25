import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int h = s.nextInt(), m = s.nextInt(), C = s.nextInt();
        int newHnM = 0, newH = 0, newM = 0;
        newHnM = (h * 60 + m) + C;

        if(newHnM >= 60 * 24) {
            newHnM -= 60 * 24;
        }

        newH = newHnM / 60;
        newM = newHnM - newH * 60;


        System.out.println(newH + " " + newM);
    }
}