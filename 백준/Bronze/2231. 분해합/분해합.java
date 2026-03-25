import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = n - (n+"").length() * 9; //생성자 후보
        int result = 0;

        for (int i = 0; i < (n+"").length() * 9; i++) {
            String st = m + "";
            char[] c = st.toCharArray();
            int sum = 0;
            for (char value : c) {
                sum += (value - '0');
            }
            if(sum + m == n) {
                result = m;
                break;
            }
            m++;
        }
        System.out.println(result);
        /*
        어떤 자연수 n의 생성자는
        n보다 작다
        n-(n의 자릿수*9)보단 크다
        그 사이에서 생성자를 찾으면 된다
        반복횟수는 n의 자릿수*9
         */
    }
}