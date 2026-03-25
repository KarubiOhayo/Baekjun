import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add(s.nextInt());
        }
        nums.sort(Comparator.naturalOrder());

        for(int num : nums) System.out.println(num);
    }
}
