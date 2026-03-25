import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.next().toUpperCase();
        int callTime = 0;
        String[] alphabet = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        //아래 if 문 안의 contains 메소드는 if(alphabet[j].indexOf(st.charAt(i) != -1) 로 대체 가능
        //String.contains(String) 메소드는 파라미터로 문자열을 받고 return 값이 boolean 이지만
        //String.indexOf(char) 메소드는 파라미터로 char을 받고 문자열 내에서 처음 char이 나타나는 위치를 반환하고 없을시 -1을 반환함
        
        for (int i = 0; i < st.length(); i++) {
            for (int j = 0; j < 8; j++) {
                if(alphabet[j].contains(String.valueOf(st.charAt(i)))) { 
                    callTime += (j + 3);
                }
            }
        }

        System.out.println(callTime);
    }
}
