package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 실버2 2630번 색종이 만들기
// 2025 09 30
public class B_2630_GPT {
  static int N;
  static int[][] paper;
  static int white = 0;
  static int blue = 0;
  /*
   * 정사각형 모양의 종이는 하얀색 혹은 파란색으로 칠해져 있다.
   * 전체 종이의 크기는 NxN(N=2^k, k는 1 이상 7 이하의 자연수)
   * 2*2 ~ 128*128
   * 정사각형을 계속 4등분 해서 한 정사각형 안에 0 또는 1만 들어가도록 한다.
   */

  /**
   * 핵심 아이디어는 재귀와 static
   * 처음 발상은 정복되지 않은 배열을 쪼개서 새로운 배열을 만드는 것
   * 하지만 그렇게 하면 새로운 배열의 수가 너무 많아지고, 배열의 index를 정하는 것도 너무 복잡해짐
   * 따라서 쪼갠다 <- 이걸 물리적 분리가 아닌 논리적 분리로 행함
   * 다음 재귀 영역에서, 논리적으로 쪼개진 배열의 [0][0]을 row, col 이라는 임의의 변수로 받음
   * 쪼개진 배열의 크기는 size로 받음
   * 임의의 변수로 받기 때문에, divide()라는 재귀 메서드가 해당 배열이 정복됐는지 확인하는 부분에서
   * static 변수인 paper를 구간 별로 탐색할 수 있게 됨
   * 계속 4등분을 해 나가기 때문에, mid(쪼개진 배열의 size)는 기존 size의 절반이 됨
   * 좌상단은 row, col, mid
   * 우상단은 row, col+mid, mid
   * 좌하단은 row+mid, col, mid
   * 우하단은 row+mid, col+mid, mid
   * 이러면 col+mid부터 mid까지 탐색하는게 아니냐? 할 수 있지만,
   * mid는 말 그대로 배열의 size 이고 실제 배열의 index가 아니기 때문에
   * 실제 isConquered()를 수행 할 때는 paper[row][col] 부터 paper[row+mid][col+mid] 까지 탐색함
   * 그럼 변수명은 mid 보다는 half가 적절할듯
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    paper = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    divide(0, 0, N);
    System.out.println(white + "\n" + blue);
  }

  // 색종이가 정복되었는지 확인하고, 정복되지 않은 색종이를 자르는 메서드
  static void divide(int row, int col, int size) {
    if (isConquered(row, col, size)) {
      if (paper[row][col] == 0) {
        white++;
      } else  {
        blue++;
      }
      return;
    }
    int mid = size / 2;
    divide(row, col, mid);
    divide(row, col + mid, mid);
    divide(row + mid, col, mid);
    divide(row + mid, col + mid, mid);
  }

  // 색종이가 정복되었는지 확인하는 메서드
  // first 값을 먼저 찾고 비교하는 것 까지는 맞았음, 초기값 r, c 부분은 틀림
  static boolean isConquered(int row, int col, int size) {
    int first = paper[row][col];
    for (int i = row; i < row + size; i++) {
      for (int j = col;  j < col + size; j++) {
        if (paper[i][j] != first) {
          return false;
        }
      }
    }
    return true;
  }

}
