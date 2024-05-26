import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private final Set<String> dict = new HashSet<>();
    private final List<String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        for (String temp : wordDict)
            dict.add(temp);

        dfs(s, 0, 0, "");

        return ans;
    }

    private void dfs(String s, int left, int right, String sentence) {
        int N = s.length();
        if (left >= N || right >= N) {
            ans.add(sentence.toString().trim());
            return;
        }

        StringBuilder local = new StringBuilder(sentence);

        while (right < N) {
            String word = s.substring(left, right + 1);

            if (dict.contains(word)) {
                local.append(word);
                local.append(' ');

                dfs(s, right + 1, right + 1, local.toString());

                local = new StringBuilder(sentence);
            }

            right++;

        }

    }
}