class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;

        int i = 0;
        int output = 0;

        while(i<chars.length){
            int count = 1;
            char prev = chars[i];

            while(i+count<chars.length && prev == chars[i+count]){
                count++;
                
            }

            chars[output++] = prev;
            if(count>1){
                for(char c : String.valueOf(count).toCharArray()){
                    chars[output++] = c;
                }
            }

            i+=count;
        }
        
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compress("abbbbbbbbbbbb".toCharArray()));
    }
}