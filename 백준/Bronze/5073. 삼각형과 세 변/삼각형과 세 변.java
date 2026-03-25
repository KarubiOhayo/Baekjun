import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);

        while(true) {
            int a = s.nextInt() , b = s.nextInt(), c = s.nextInt();
            if(a == 0 && b == 0 && c == 0) break;
            System.out.println(triangle(a, b, c));
        }
    }

    static String triangle(int a, int b, int c) {
        List<Integer> line = new ArrayList<>();
        line.add(a);
        line.add(b);
        line.add(c);
        HashSet<Integer> lineHash = new HashSet<>(line);

        int max = Collections.max(lineHash);

        line.remove(Integer.valueOf(max));

        int isTri = line.stream()
                        .mapToInt(Integer::intValue)
                                .sum();

        if(max >= isTri) return "Invalid";

        switch (lineHash.size()) {
            case 3:
                return "Scalene";
            case 2:
                return "Isosceles";
            case 1:
                return "Equilateral";
            default:
                return "Error";
        }
    }
}
