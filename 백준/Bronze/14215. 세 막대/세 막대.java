import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt(), b = s.nextInt(), c = s.nextInt();
        System.out.println(triangle(a, b, c));
    }

    static int triangle(int a, int b, int c) {
        List<Integer> lines = new ArrayList<>();
        lines.add(a);
        lines.add(b);
        lines.add(c);

        int max = Collections.max(lines);
        int sumOthers = lines.stream().mapToInt(Integer::intValue).sum() - max;

        if(max >= sumOthers) max = sumOthers - 1;

        return max + sumOthers;
    }
}
