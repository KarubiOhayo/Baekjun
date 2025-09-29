package programers;

import java.util.*;

public class Solution_42748 {
  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for (int i = 0; i < answer.length; i++) {
      int start = commands[i][0] - 1;
      int end = commands[i][1] - 1;
      int cursor = commands[i][2] - 1;
      List<Integer> temp = new ArrayList<>();

      for (int j = start; j <= end; j++) {
        temp.add(array[j]);
      }
      Collections.sort(temp);
      answer[i] = temp.get(cursor);
    }

    return answer;
  }
}
