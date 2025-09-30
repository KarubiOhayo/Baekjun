package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B_1927 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int x;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      x = Integer.parseInt(br.readLine());
      if (x == 0) {
        if (pq.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(pq.poll()).append("\n");
        }
      } else {
        pq.add(x);
      }
    }
    System.out.println(sb);
  }
}
