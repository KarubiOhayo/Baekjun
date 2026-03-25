import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<long[]> rows = new ArrayList<>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      rows.add(new long[] {Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())});
    }

    rows = rows.stream()
        .sorted(Comparator.comparingLong((long[] a) -> a[1]).thenComparing((long[] a) -> a[0]))
        .collect(Collectors.toCollection(ArrayList::new));


    int count = 0;
    long end = 0;

    for (long[] row : rows) {
      if (row[0] >= end) {
        count++;
        end = row[1];
      }
    }

    System.out.println(count);
  }

}