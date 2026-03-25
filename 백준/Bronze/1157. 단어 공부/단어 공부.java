import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String st = s.next().toUpperCase();
        ArrayList<Character> stChar = new ArrayList<>();

        for (int i = 0; i < st.length(); i++) {
            if(!stChar.contains(st.charAt(i))) {
                stChar.add(st.charAt(i));
            }
        }
        int[] sameCount = new int[stChar.size()];

        for (int i = 0; i < stChar.size(); i++) {
            for (int j = 0; j < st.length(); j++) {
                if(stChar.get(i) == st.charAt(j)) {
                    sameCount[i]++;
                }
            }
        }
        int max = sameCount[0];

        for (int i = 1; i < sameCount.length; i++) {
            if(max < sameCount[i]) {
                max = sameCount[i];
            }
        }
        int count = 0;

        for (int i = 0; i < sameCount.length; i++) {
            if(max == sameCount[i]){
                sameCount[i] = 0;
                count++;
            }
        }

        for (int i = 0; i < sameCount.length; i++) {
            if(count > 1) {
                System.out.println("?");
                break;
            }
            if(sameCount[i] == 0) {
                System.out.println(stChar.get(i));
            }
        }
    }
}
