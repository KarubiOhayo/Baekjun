import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());
        List<String[]> cases = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            cases.add(br.readLine().split("X"));
        }

        for (int i = 0; i < testCases; i++) {
            int result = 0;
            for (int j = 0; j < cases.get(i).length; j++) {
                result += (cases.get(i)[j].length())*(cases.get(i)[j].length()+1)/2;
            }
            System.out.println(result);
        }
    }
}
