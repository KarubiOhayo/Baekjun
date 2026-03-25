import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int R = s.nextInt();

        for (int o = 0; o < R; o++) {

            int testNum = s.nextInt();
            String st = s.next();
            char[] P = new char[testNum * st.length()];

            for (int i = 1; i <= st.length(); i++) {
                for (int j = 1; j <= testNum; j++) {
                    P[(j - 1) + ((i - 1) * testNum)] = st.charAt(i - 1);
                }
            }
            String newP = new String(P);
            System.out.println(newP);
        }
    }
}