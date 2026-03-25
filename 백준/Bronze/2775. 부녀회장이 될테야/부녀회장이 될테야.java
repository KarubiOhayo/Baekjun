import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t =  Integer.parseInt(br.readLine());

        for (int o = 0; o < t; o++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] rooms = new int[k + 1][n];

            for (int i = 0; i < n; i++) {
                rooms[0][i] = i + 1;
            }
            for (int i = 0; i <= k; i++) {
                rooms[i][0] = 1;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j < n; j++) {
                    rooms[i][j] = rooms[i - 1][j] + rooms[i][j - 1];
                }
            }
            System.out.println(rooms[k][n - 1]);
        }
    }
}
