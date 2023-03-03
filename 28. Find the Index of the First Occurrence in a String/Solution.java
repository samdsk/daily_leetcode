class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        int i = 0;
        while(i<haystack.length()){
            int j = 0;            
            int temp = i;
            while(j<needle.length() && haystack.charAt(temp)==needle.charAt(j)){                
                j++;   
                temp++;             
            }

            if(j>=needle.length()) return i;
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi", "issip"));
    }
}
