class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Collections.sort(dictionary, (a,b) -> a.length() - b.length());
        
        StringBuilder ans = new StringBuilder();

        for(String word : words){
            String subtituite = word;

            for(String dict : dictionary){
                // dict = cat, word = cattle
                if(dict.length() <= word.length()){
                    int i = 0;
                    while(i < dict.length()){
                        if(dict.charAt(i) != word.charAt(i)) break;
                        i++;
                    }

                    if(i == dict.length()){
                        subtituite = dict;
                        break;
                    }
                }
            }

            ans.append(subtituite).append(' ');

        }
        return ans.toString().trim();
    }
}

