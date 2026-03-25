import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        int result = 0;
        int testNum = s.nextInt();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < testNum; i++) {
            x.add(s.nextInt());
            y.add(s.nextInt());
        }

        int xMin = x.stream().mapToInt(Integer::intValue).min().getAsInt();
        int yMin = y.stream().mapToInt(Integer::intValue).min().getAsInt();
        int xMax = x.stream().mapToInt(Integer::intValue).max().getAsInt();
        int yMax = y.stream().mapToInt(Integer::intValue).max().getAsInt();

        System.out.println((xMax - xMin) * (yMax - yMin));

        //xy좌표의 최소 최댓값들을 각각 구한다. 각자 최솟값에서 최댓값을 뺀 값들을 곱하면 넓이가 나온다.
    }
}
