import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        List<String> st =  Arrays.asList(n.split(""));
        st.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String num : st) {
            sb.append(num);
        }
        System.out.print(sb);
    }
}
