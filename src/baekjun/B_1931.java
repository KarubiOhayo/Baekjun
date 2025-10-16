package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// 백준 1931 회의실 배정
// 그리디 알고리즘
public class B_1931 {

  /*
   * N개의 회의에 대한 회의실 사용표
   * 각 회의 I에 대해 시작시간 끝나는 시간 주어져 있음
   * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수 찾기
   * 1 <= N <= 100,000
   * 범위를 이용한 문제인가?
   * 그리디 알고리즘을 사용하는 문제
   *
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
   * 이런 입력이 있을 때 (1, 4) (5, 7) (8, 11) (12, 14)이렇게 해서 답이 4
   * 그리디 알고리즘이란게 유사 최적해를 구하는 알고리즘인데,
   * 여기서 1, 4를 고른 이유? 끝나는 시간이 가장 짧아서
   * 총 회의 시간이 얼마나 걸리는지는 상관 없음
   * 끝나는 시간이 빠를 수록 더 많은 회의가 가능하니까
   *
   * 그럼 뒷부분을 기준으로 정렬 해 놓고, 마지막 회의가 끝난 시간을 저장 해 둠
   * 그리고 마지막 회의가 끝난 이후에 시작하는 놈을 골라서 끝난 시간 갱신하고 카운트 올림
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<long[]> rows = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      rows.add(new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())});
    }

    rows = rows.stream()
        .sorted(Comparator.comparingLong((long[] a) -> a[1]).thenComparing((long[] a) -> a[0]))
        .collect(Collectors.toCollection(ArrayList::new));

    // 스트림 없이
    rows.sort(Comparator.comparingLong((long[] a) -> a[1]).thenComparing((long[] a) -> a[0]));

//    // 배열 정렬
//    long[][] test = new long[n][2];
//    for (int i = 0; i < rows.size(); i++) {
//      test[i][0] = rows.get(i)[0];
//      test[i][1] = rows.get(i)[1];
//    }
//
//    Arrays.sort(test, (o1, o2) -> {
//      if (o1[1] == o2[1]) {
//        return (int) (o1[0] - o2[0]);
//      }
//      return (int) (o1[1] - o2[1]);
//    });
//
//    for (long[] longs : test) {
//      System.out.println(Arrays.toString(longs));
//    }

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
