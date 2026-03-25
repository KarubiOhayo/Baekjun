import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //int n = s.nextInt();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            nums.add(s.nextInt());
        }

        for (int i = 0; i < nums.size(); i++) {
            int minIndex = i;

            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(minIndex) >  nums.get(j)) minIndex = j;
            }
            int save = nums.get(i);
            nums.set(i, nums.get(minIndex));
            nums.set(minIndex, save);
        }

        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum / 5);
        System.out.println(nums.get(2));
    }
}
