// Using XOR
class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for(char temp : s.toCharArray()) c ^= temp;
        for(char temp : t.toCharArray()) c ^= temp;
        return c;
    }
}