class Solution {
    public String freqAlphabets(String s) {
        StringBuilder ans = new StringBuilder();

        for (int i = s.length() -1 ; i >=0; i--) {
            if(s.charAt(i) == '#'){
                char c = (char)('a' + (s.charAt(i-1) - '0') + 10 * (s.charAt(i-2) - '0') -1);
                ans.append(c);
                i -= 2;
            }else ans.append((char)('a' + (s.charAt(i) - '0') -1));
        }

        return ans.reverse().toString();
    }
}