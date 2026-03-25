import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] fruits = new int[N];

		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> map = new HashMap<>();
		int maxLen = 0;
		int left = 0;
		for (int right = 0; right < N; right++) {
			map.put(fruits[right], map.getOrDefault((fruits[right]), 0) + 1);
			while (map.size() > 2) {
				int leftFruit = fruits[left];
				map.put(leftFruit, map.get(leftFruit) - 1);

				if (map.get(leftFruit) == 0) {
					map.remove(leftFruit);
				}
				left++;
			}

			maxLen = Math.max(maxLen, right - left + 1);
		}

		System.out.println(maxLen);
	}
}