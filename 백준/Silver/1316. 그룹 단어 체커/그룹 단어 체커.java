import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Character> stChar = new ArrayList<>();
        int count = 0;

        int testNum = s.nextInt();
        for (int i = 0; i < testNum; i++) {
            stChar.clear();
            String st = s.next();
            stChar.add(st.charAt(0));
            int a = 0;


            for (int j = 0; j < st.length(); j++) {
                if (!stChar.contains(st.charAt(j))) {
                    stChar.add(st.charAt(j));
                }
            }

            for (int j = 0; j < stChar.size(); j++) {
                int b = 0;
                for (int k = st.indexOf(stChar.get(j)); k < st.length(); k++) {

                    if (st.charAt(k) == stChar.get(j) && b != 0) {
                        count++;
                        a++;
                        break;
                    }
                    if (st.charAt(k) != stChar.get(j)) {
                        b++;
                    }
                    if(a != 0) {
                        break;
                    }
                }
            }
        }
        
        System.out.println(testNum - count);
    }
}