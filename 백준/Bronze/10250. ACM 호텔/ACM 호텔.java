import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());
        String[] strings = new String[testNum];

        for (int i = 0; i < testNum; i++) {
            strings[i] =  br.readLine();
        }

        for (int k = 0; k < testNum; k++) {
            int[] stringToInt = Arrays.stream(strings[k].split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int height = stringToInt[0];
            int width = stringToInt[1];
            int cNum = stringToInt[2];
            int[][] rooms = new int[height][width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j + 1 < 10) rooms[i][j] = Integer.parseInt((i + 1 + "") + "0" + (j + 1 + ""));
                    else rooms[i][j] = Integer.parseInt((i + 1 + "") + (j + 1 + ""));
                }
            }
            int roomCount = 1;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (roomCount == cNum) System.out.println(rooms[j][i]);
                    roomCount++;
                }
            }
        }
    }
}
