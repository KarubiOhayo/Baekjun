import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String isbn = br.readLine();
        String[] isbns = isbn.split("");

        int sum = 0;
        int checkIndex = 0;
        for (int i = 0; i < isbns.length; i++) {
            if(!isbns[i].equals("*")) {
                if((i + 1) % 2 == 0) {
                    sum += Integer.parseInt(isbns[i])*3;
                }
                else sum += Integer.parseInt(isbns[i]);
            }
            else checkIndex = i + 1;
        }

        if(checkIndex % 2 == 0) {
            for (int i = 0; i < 10; i++) {
                if((sum + i * 3) % 10 == 0) System.out.println(i);
            }
        }
        else {
            for (int i = 0; i < 10; i++) {
                if((sum + i) % 10 == 0) System.out.println(i);
            }
        }
    }
}
