import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int[] counting = new int[10001];
        int[] result = new int[n];

        for (int i = 0; i < nums.length; i++) {
            counting[nums[i]]++;
        }
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int value = nums[i];
            counting[value]--;
            result[counting[value]] = value;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append('\n');
        }
        System.out.print(sb);
    }
}
