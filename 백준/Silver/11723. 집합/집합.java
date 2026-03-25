import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            List<String> list = Arrays.asList(br.readLine().split(" "));

            switch (list.get(0)) {
                case "add":
                    set.add(Integer.parseInt(list.get(1)));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(list.get(1)));
                    break;
                case "check":
                    if (set.contains(Integer.parseInt(list.get(1)))) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case "toggle":
                    if (set.contains(Integer.parseInt(list.get(1)))) {
                        set.remove(Integer.parseInt(list.get(1)));
                    } else {
                        set.add(Integer.parseInt(list.get(1)));
                    }
                    break;
                case "all":
                    set = IntStream.rangeClosed(1, 20)
                            .boxed()
                            .collect(Collectors.toSet());
                    break;
                default: // "empty"
                    set.clear();
            }
        }
        System.out.println(sb);
    }
}
