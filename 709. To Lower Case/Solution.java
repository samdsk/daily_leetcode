class Solution {
    public String toLowerCase(String s) {
        StringBuilder ans = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c >= 'A' && c <= 'Z') ans.append((char)(c + 'a' - 'A'));
            else ans.append(c);
        }

        return ans.toString();
    }
}