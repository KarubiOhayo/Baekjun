import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        System.out.println((long)n * n);  // 수행 횟수
        System.out.println("2");          // 차수
    }
}