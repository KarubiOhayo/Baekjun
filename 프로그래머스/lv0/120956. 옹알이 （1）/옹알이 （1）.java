class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] ableArr = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            String curr = babbling[i];
            for (int j = 0; j < ableArr.length; j++) {
                curr = curr.replace(ableArr[j], " ");
                if (curr.isBlank()) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}