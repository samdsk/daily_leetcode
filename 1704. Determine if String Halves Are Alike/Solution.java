class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>();
        
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        int n = s.length();
        int half = n/2;
        int count = 0;

        for(int i=0;i<half;i++){
            if(vowels.contains(s.charAt(i))) count++;
            if(vowels.contains(s.charAt(i+half))) count--;
        }

        return count == 0;
    }
}