import java.util.*;
/*
brown + yellow를 하면 카펫의 총 크기가 나온다.
yellow는 1이상이므로 카펫 한 변의 길이는 최소 3이다.
yellow로 이루어진 영역의 크기는 카펫의 가로, 세로 길이에서 각각 2씩을 뺀 크기이다.
카펫의 총 면적이 3 이상의 수로 나누어 떨어질 때 가로 세로 길이의 조합에서, 2씩 뺀 값을 서로 곱했을 때 yellow의 총 면적과 맞아 떨어진다면 그게 답.

*/


class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int area = brown + yellow;
        for (int i = 3; i < area; i++) {
            if (area % i != 0) continue;
            int n = area / i;
            if ((i - 2) * (n - 2) == yellow) {
                return new int[]{Math.max(i, n), Math.min(i, n)};
            }
        }
        
        return answer;
    }
}