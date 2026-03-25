import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.nextLine();
        int wordCount = 1;

        for (int i = 1; i < st.length(); i++) {

            if(st.charAt(i - 1) == ' ' && st.charAt(i) != ' '){
                wordCount++;
            }
        }
        if(st.charAt(0) == ' ') {
            wordCount--;
        }

        System.out.println(wordCount);
    }
}
