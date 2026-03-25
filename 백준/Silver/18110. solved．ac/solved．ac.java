import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());
        List<Integer> difficulties = new LinkedList<>();
        int sum = 0;

        for (int i = 0; i < testCases; i++) {
            difficulties.add(Integer.parseInt(br.readLine()));
            sum += difficulties.get(i);
        }
        Collections.sort(difficulties);

        int delete = (int) Math.round((double) difficulties.size() * 0.15);

        for (int i = 0; i < delete; i++) {
            sum -= difficulties.remove(0);
            sum -= difficulties.remove(difficulties.size() - 1);
        }

        int avg = (int) Math.round((double) sum / difficulties.size());

        System.out.println(avg);
    }
}
