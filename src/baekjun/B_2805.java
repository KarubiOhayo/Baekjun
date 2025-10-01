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
public class B_2805 {

  static int N;
  static int M;

  /*어디가 잘못됐는지

  잘라서 얻는 길이(sum) 계산이 틀림
  자르는 높이가 H일 때는 전체 나무에 대해 max(0, h - H)를 전부 더해야 해.
  지금 코드는 subList(0, mid) 같은 일부 구간만 합하고, mid 위치의 나무도 빠지고, 같은 높이가 여러 개 있을 때도 누락돼. 그래서 항상 과소/과대 계산이 나와.

  이분 탐색 수렴 조건이 이상함
  mid == (start + end) / 2로 종료를 판단하면 경계에서 무한 루프 혹은 조기 종료가 나와.
  표준 패턴인 while (lo <= hi)/lo = mid + 1, hi = mid - 1로 가야 안전해.

      오프바이원 + 정렬 전제에 묶인 설계
  findMaxHeight에서 subList(0, index - 1)는 한 칸 덜 봄(오프바이원).
  그리고 “내림차순 정렬 + 인덱스 경계” 가정 자체가 복잡도를 올리고, 중복 높이에서 쉽게 깨져.

      성능/안정성
  매 반복마다 stream().sum()을 새로 돌리면서 리스트를 잘라 쓰니 불필요한 오버헤드가 생겨.
  표준 해법은 높이(H) 자체에 대한 이분 탐색으로 간단하고 안전해.*/

  /**
   * 상근이는 나무 M미터가 필요하다. 목재절단기에 높이 H를 지정해야 한다. 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다. 그 다음 한 줄에 연속해있는 나무를 모두
   * 절단한다. 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다. 한 줄에 연속된 나무가 각각 높이 20, 15, 10, 17 이고
   * 높이를 15로 지정했다면 자른 뒤의 높이는 15, 15, 10, 15가 되고 총 7미터의 나무를 들고 집에 갈 것이다. 나무를 최소 M미터 가져가고 싶을 때 절단기에
   * 설정할 수 있는 높이의 최댓값을 구하라. 첫 줄에 나무의 수 N과 필요한 나무의 길이 M이 주어진다. 둘째 줄에는 나무의 높이가 주어진다.
   *
   *
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    List<Integer> trees = Arrays.stream(br.readLine().split(" "))
        .map(Integer::parseInt)
        .sorted(Comparator.comparingInt(Integer::intValue).reversed())
        .toList();

    int index = findMaxIndex(trees);
    if (index < 0) {
      System.out.println(index * -1);
    } else {
      System.out.println(findMaxHeight(trees, index));
    }

     /*
     4 7
     20 15 10 17
     일 때 답은 15
     각각 5미터, 2미터 가져가니 맞음
     62 / 4
     일단 평균은 아님
     제일 높은 숫자를 찾는다
     그 다음 숫자를 찾는다
     일단 정렬을 해
     그럼 최대 높이는(0미터가 필요하다고 했을 때)
     trees.get(0)이 되겠지
     그리곤 1미터씩 내려오면서 찾아보는거야
     하나일때는 필요한 나무의 길이 m이 1씩 증가할거고
     두개가 되면 2씩 증가하겠지?
     이거 이진탐색 되나?

     너무 작을 때는 아래로 다시 반절 자르면 되는데
     너무 클 때는 어떻게 판단하지?

     sum이 H보다 크면 위로, 작으면 아래로 간다.
     마지막에 max가 1 낮아졌는데 작다면? 1 올린 값을 반환한다.


     */
  }

  static int findMaxIndex(List<Integer> trees) {
    int start = 0;
    int end = trees.size() - 1;
    int mid = (start + end) / 2;
    int max = 0;
    while (true) {
      max = trees.get(mid);
      List<Integer> temp = trees.subList(0, mid);
      int sum = temp.stream().mapToInt(Integer::intValue).sum() - (max * temp.size());

      if (sum > M) {
        end = mid;
        if (mid == (start + end) / 2) {
          return mid;
        }
      } else if (sum < M) {
        start = mid;
        if (mid == (start + end) / 2) {
          return mid + 1;
        }
      } else {
        return max * -1;
      }
      mid = (start + end) / 2;
    }
  }

  static int findMaxHeight(List<Integer> trees, int index) {
    int start = trees.get(index);
    int end = trees.get(index - 1);
    int mid = (start + end) / 2;
    List<Integer> temp = trees.subList(0, index - 1);

    while (true) {
      int sum = temp.stream().mapToInt(Integer::intValue).sum() - (mid * temp.size());
      if (sum > M) {
        start = mid;
        if (mid == (start + end) / 2) {
          return mid;
        }
      } else if (sum < M) {
        end = mid;
        if (mid == (start + end) / 2) {
          return mid - 1;
        }
      } else {
        return mid;
      }
      mid = (start + end) / 2;
    }
  }

  /*
  100
  90
  80
  70
  50
  40
  30
  20
  10
  1
   */


}
