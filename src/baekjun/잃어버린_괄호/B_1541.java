package baekjun.잃어버린_괄호;

// 백준 실버2 1541번 잃어버린 괄호
// 2025.11.20

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 양수, +, -, 괄호를 사용해 식을 만든 뒤 괄호를 모두 지웠다.
 * 이후 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 * 55-50+40
 * 10+20+30+40
 * 00009-00009
 * 예시 문항
 * 최솟값 구하는 법: - 사이 +로 묶인 수를 전부 괄호로 묶는다.
 *
 * 주어진 문자열 파싱하는 법
 * - 혹은 +가 나올 때 해당 기호의 위치를 기록한 뒤 공백으로 치환한다.
 * 처음은 무조건 +이다.
 * split 후 계산한다.
 */
public class B_1541 {
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
		int sum = list.getFirst();

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
