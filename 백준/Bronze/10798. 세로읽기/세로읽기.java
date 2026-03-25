import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] st = new String[5];
        int maxIndex = 0;

        for (int i = 0; i < 5; i++) {
            st[i] = s.next();
            if(maxIndex < st[i].length()){
                maxIndex = st[i].length();
            }
        }

        Character[][] toy = new Character[5][maxIndex];

        for (int i = 0; i < st.length; i++) {
            for (int j = 0; j < st[i].length(); j++) {
                toy[i][j] = st[i].charAt(j);
            }
        }

        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < 5; j++) {
                if(toy[j][i] != null) {
                    System.out.print(toy[j][i]);
                }
            }
        }
    }
}