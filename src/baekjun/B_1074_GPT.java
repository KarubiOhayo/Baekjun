package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 골드5 1074 - Z
public class B_1074_GPT {
  /*
   * 크기가 2^n * 2^n인 2차원 배열을 Z 모양으로 탐색
   * n > 1인 경우, 배열을 크기가 2^(n-1) * 2^(n-1)로 4등분 한 후에 재귀적으로 순서대로 방문
   * N이 주어졌을 때 r행 c열을 몇 번째로 방문하는지 출력하라
   * r, c는 0부터 2^n 까지
   * N은 1부터 15까지
   *
   * 최대 범위는 2^15 * 2^15
   * 제일 큰 숫자는 10억정도
   * 입력은 N, r, c
   *
   * 내가 찾는 칸(r, c)가 어느 사분면에 있는지 판단 후 그 사분면 안의 더 작은 사분면으로 줄여가는 아이디어가 핵심
   * N, r, c가 주어졌을 때, 어느 사분면에 있는지 어떻게 판단하지?
   * r, c는 최초에는 2^N - 1이 최댓값
   * 각 사분면의 최소 최댓값을 생각하면
   * (0, 0)             | (2^(N-1)-1, 2^(N-1)-1) 1사분면 (편의상 Z 모양으로 1234사분면 나눔)
   * (0, 2^(N-1))       | (2^(N-1)-1, (2^N)-1)   2사분면
   * (2^(N-1), 0)       | ((2^N)-1, 2^(N-1)-1)   3사분면
   * (2^(N-1), 2^(N-1)) | ((2^N)-1, (2^N)-1)     4사분면
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    System.out.println(solve(N, r, c));
  }

  /*
   * 재귀 메서드 conquer에 들어가야 하는 매개변수
   * 사분면 정보(0123)
   */
  static long solve(int n, int row, int col) {
    if(n == 0) {
      return 0;
    }
    int half = 1 << (n - 1);

    int q;
    int nr = row, nc = col;

    if (row < half && col < half) {
      q = 0;
    } else if (row < half) {
      q = 1;
      nc -= half;
    } else if (col < half) {
      q = 2;
      nr -= half;
    } else {
      q = 3;
      nr -= half;
      nc -= half;
    }

    return (long) q * half * half + solve(n - 1, nr, nc);
  }
}
