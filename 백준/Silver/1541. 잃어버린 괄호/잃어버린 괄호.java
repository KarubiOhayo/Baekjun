import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<Integer> list = new ArrayList<>();
		int index = 0;

		for (int i = 0; i < str.length(); i++) {
			boolean b = str.charAt(i) == '-' || str.charAt(i) == '+';
			
			if (b && index == 0) {
				list.add(Integer.parseInt(str.substring(index, i)));
				index = i;
				continue;
			}
			if (b) {
				list.add(Integer.parseInt(str.substring(index, i)));
				index = i;
				continue;
			}
			if (i == str.length() - 1) {
				list.add(Integer.parseInt(str.substring(index, i + 1)));
				index = i;
			}
		}

		boolean isMinus = false;
		int sum = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			int num = list.get(i);
			if (num < 0) {
				sum += num;
				isMinus = true;
				continue;
			}
			if (num > 0 && isMinus) {
				sum -= num;
				continue;
			}
			sum += num;
		}

		System.out.println(sum);
	}
}