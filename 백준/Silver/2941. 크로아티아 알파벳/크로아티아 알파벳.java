import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String st = s.next();
        int length = st.length();


        for (String string : croatia) {
            if (st.contains(string)) {
                st = st.replace(string, "A");
            }
        }
        System.out.println(st.length());
    }
}