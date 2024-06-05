class Solution {
    public List<String> commonChars(String[] words) {
        int[] main = charFreq(words[0]);

        for (int i = 1; i < words.length; i++) {
            main = common(words[i], main);
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (main[i] > 0) {
                String temp = "" + (char) ('a' + i);
                ans.add(temp);
                for (int j = 1; j < main[i]; j++) {
                    ans.add(temp);
                }
            }
        }

        return ans;
    }

    private int[] common(String s, int[] tFreq) {
        int[] sFreq = charFreq(s);

        int[] res = new int[26];

        for (int i = 0; i < 26; i++) {
            res[i] = Math.min(sFreq[i], tFreq[i]);
        }

        return res;
    }

    private int[] charFreq(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        return freq;
    }
}