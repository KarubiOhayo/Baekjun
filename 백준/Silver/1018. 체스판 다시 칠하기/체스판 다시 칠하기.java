import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(), m = s.nextInt();
        List<String> rows = new ArrayList<>();
        List<Integer> paintNum = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rows.add(s.next());
        }

        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                paintNum.add(findMinPaint(i, j, rows));
            }
        }

        /*
        체스판 칠하기
        큰 베이스에서 8*8을 어떻게 적절히 찾아 낼 것인가.
        어디가 가장 적게 칠해도 되는지 찾아낸다.
        (m-8)*(n-8)번 반복한다.
        다시 칠해야 하는 최솟값을 찾는걸
        최솟값 찾는 함수 분리
        첫번째가 W라면 wbwb
        첫번째가 b라면 bwbw
        다른거 찾을 때 마다 카운트
        그 카운트를 저장
        그 중 최솟값을 출력
         */
        System.out.println(Collections.min(paintNum));
    }

    static int findMinPaint (int i, int j, List<String> rows) {
        int count = 0;
        int count2 = 0;
        char wb = 'W';

        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if(!Objects.equals(rows.get(k).charAt(l), wb)) {
                    count++;
                }
                switch(wb) {
                    case 'W':
                        wb = 'B';
                        break;
                    case 'B':
                        wb = 'W';
                        break;
                }
            }
            switch(wb) {
                case 'W':
                    wb = 'B';
                    break;
                case 'B':
                    wb = 'W';
                    break;
            }
        }
        wb = 'B';

        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if(rows.get(k).charAt(l) != wb) {
                    count2++;
                }
                switch(wb) {
                    case 'W':
                        wb = 'B';
                        break;
                    case 'B':
                        wb = 'W';
                        break;
                }
            }
            switch(wb) {
                case 'W':
                    wb = 'B';
                    break;
                case 'B':
                    wb = 'W';
                    break;
            }
        }
        return Math.min(count, count2);
    }
}
