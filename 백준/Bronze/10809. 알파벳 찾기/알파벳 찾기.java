import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.next();
        int[] stArray = new int[26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < st.length(); j++) {
                if(st.charAt(j) == i + 'a') {
                    stArray[i] = j;
                    break;
                }
                else {
                    stArray[i] = -1;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(stArray[i] + " ");
        }
    }
}