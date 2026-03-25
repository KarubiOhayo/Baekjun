import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		List<Integer> map = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map.add(Integer.parseInt(st.nextToken()));
			}
		}

		int time = Integer.MAX_VALUE;
		int height = 0;
        int block = map.stream().mapToInt(x -> x).sum() + B;

		for (int i = 0; i <= 256; i++) {
			int temp = 0;
			if ((i * map.size()) > block) {
				continue;
			}
			for (int num : map) {
                if (num == i) continue;
				if (num < i) {
					temp += i - num;
				} else {
					temp += (num - i) * 2;
				}
			}
			if (temp <= time) {
				time = temp;
				height = i;
			}
		}

		System.out.println(time + " " + height);
	}
}