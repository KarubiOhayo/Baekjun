import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            String line = br.readLine();
            boolean yesOrNo = true;

            int left = 0;
            int right = 0;

            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '(') left++;
                if (line.charAt(j) == ')') right++;
                if (right > left) {
                    yesOrNo = false;
                }
            }

            if(yesOrNo) {
                yesOrNo = left == right && line.charAt(0) != ')' && line.charAt(line.length() - 1) != '(';
            }
            if(yesOrNo) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}
