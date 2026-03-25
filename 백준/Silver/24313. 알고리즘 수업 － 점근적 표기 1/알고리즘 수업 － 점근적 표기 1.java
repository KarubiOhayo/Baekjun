import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a1 = s.nextInt(), a0 = s.nextInt();
        int c =  s.nextInt();
        int n0 = s.nextInt();
        int result = 1;
        int n = n0;

        while(true) {
            if((a1*n)+a0 > c * n){
                result = 0;
                break;
            }
            if(((a1*n)+a0 <= c * n) && ((a1*(n+1))+a0)-((a1*n)+a0) <= (c * (n+1))-(c*n)){
                break;
            }
            n++;
        }

        System.out.println(result);
    }
}