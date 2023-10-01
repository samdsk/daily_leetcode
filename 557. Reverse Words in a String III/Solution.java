class Solution {
    public String reverseWords(String s) {
        // String[] words = s.split(" ");
        // StringBuilder ans = new StringBuilder();

        // for(String word : words){
        //     ans.append(new StringBuilder(word).reverse());
        //     ans.append(' ');
        // }
        // ans.deleteCharAt(ans.length()-1);
        // return ans.toString();

        //abc def
        //cba fed

        char[] letters = s.toCharArray();
        int left = 0, spacePos = 0;

        while(spacePos < letters.length){
            while(spacePos < letters.length && letters[spacePos] != ' ') spacePos++;
            int right = spacePos-1;

            while(left < right){
                char temp = letters[left];
                letters[left] = letters[right];
                letters[right] = temp;
                right--;
                left++;
            }

            spacePos++;
            left = spacePos;
        }

        return new String(letters);
    }
}