import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String line = br.readLine();
            if (line.equals("0 0 0")) break;
            int[] linesInt = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int longest = Arrays.stream(linesInt).max().getAsInt();
            int rests = Arrays.stream(linesInt)
                    .filter(a -> a != longest)
                    .map(a -> a * a)
                    .sum();
            if(rests == longest * longest) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}
