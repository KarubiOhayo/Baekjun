import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    long M = Long.parseLong(st.nextToken());
    long[] trees = new long[N];
    st = new StringTokenizer(br.readLine());
    long high = 0L;

    for(int i = 0; i < N; ++i) {
      trees[i] = Long.parseLong(st.nextToken());
      if (trees[i] > high) {
        high = trees[i];
      }
    }

    long low = 0L;
    long ans = 0L;

    while(low <= high) {
      long mid = low + high >>> 1;
      long got = 0L;

      for(int i = 0; i < N; ++i) {
        if (trees[i] > mid) {
          got += trees[i] - mid;
        }
      }

      if (got >= M) {
        ans = mid;
        low = mid + 1L;
      } else {
        high = mid - 1L;
      }
    }

    System.out.println(ans);
  }
}