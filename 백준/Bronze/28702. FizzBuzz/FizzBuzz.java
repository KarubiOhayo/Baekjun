import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = new String[3];
        int numIndex = 0;

        for (int i = 0; i < 3; i++) {
            st[i] = br.readLine();
            if (!st[i].equals("Fizz") && !st[i].equals("Buzz") && !st[i].equals("FizzBuzz")) {
                numIndex = i;
            }
        }

        int nextNum = Integer.parseInt(st[numIndex]) + (3 - numIndex);

        if (nextNum % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (nextNum % 3 == 0) System.out.println("Fizz");
        else if (nextNum % 5 == 0) System.out.println("Buzz");
        else System.out.print(nextNum);
    }
}