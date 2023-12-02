class Solution {
    public int countCharacters(String[] words, String chars) {
        char charArray[] = new char[26];

        for (char c : chars.toCharArray())
            charArray[c - 'a']++;
        
        int sum = 0;

        for(String word : words){
            char tempArray[] = new char[26];

            for(char c : word.toCharArray())
                tempArray[c - 'a']++;

            boolean flag = true;
            for (int i = 0; i < charArray.length; i++) {
                if(charArray[i] < tempArray[i]){
                    flag = false;
                    break;
                }
            }

            if(flag)
                sum += word.length();
        }

        return sum;
    }
}