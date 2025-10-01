package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 백준 실버2 2805 나무 자르기
// 2025 09 30
public class B_2805_GPT {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    long M = Long.parseLong(st.nextToken());

    long[] trees = new long[N];
    st = new StringTokenizer(br.readLine());
    long high = 0;
    for (int i = 0; i < N; i++) {
      trees[i] = Long.parseLong(st.nextToken());
      if (trees[i] > high) {
        high = trees[i]; // 나무 높이의 최댓값을 찾아놓는다.
      }
    }

    long low = 0; // 최솟값은 항상 0이다.
    long ans = 0;
    while (low <= high) { // 이분 탐색 시작(중간을 기준으로 값이 왼쪽에 있으면 high, 오른쪽이면 low를 갱신 해 가며 탐색, low와 high가 만나면 종료)
      long mid = (low + high) >>> 1; // (low + high)/2, overflow 안전
      long got = 0; // 중간 높이 mid에서 얻는 나무의 총 길이 got = Σ max(0, h - mid)
      for (int i = 0; i < N; i++) {
        if (trees[i] > mid) { // 자를 나무의 높이가 설정된 높이보다 작거나 같으면 총 길이에 추가하지 않음
          got += (trees[i] - mid);
          // got이 M을 훨씬 초과해도 상관없지만,
          // 미세 최적화하려면 if (got >= M) { break; } 해도 됨
        }
      }
      if (got >= M) { // 이 높이로도 M 이상 확보 -> 더 높일 수 있음
        ans = mid;
        low = mid + 1; // 이분 탐색에서 low, high 커서는 기존 mid에서 한칸 이동하는 방식으로 한다.
      } else {
        high = mid - 1;
      }
    }

    System.out.println(ans);
  }
}
