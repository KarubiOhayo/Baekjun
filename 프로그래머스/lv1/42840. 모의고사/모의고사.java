import java.util.*;
/*
1, 2, 3, 4, 5
2, 1, 2, 3, 2, 4, 2, 5
3, 3, 1, 1, 2, 2, 4, 4, 5, 5

각 배열은 이렇게 반복된다.
모듈러 연산으로 돌아가게 만들어 줄 수 있다.

맞춘 문제 수를 표현하는 배열 score[]에 추가한다.
*/

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            int answerA = a[i % a.length];
            int answerB = b[i % b.length];
            int answerC = c[i % c.length];
            int temp = answers[i];
            if (answerA == temp) {
                scores[0]++;
            }
            if (answerB == temp) {
                scores[1]++;
            }
            if (answerC == temp) {
                scores[2]++;
            }
        }
        int max = 0;
        for (int num: scores) {
            max = Math.max(max, num);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}