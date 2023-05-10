import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

    private class Pair {
        private String word;
        private int level;

        public Pair(String s, int d){
            this.word = new String(s);
            this.level = d;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLength = beginWord.length();
        Map<String,List<String>> allCombinations = new HashMap<>();

        for(String word : wordList){
            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i)+'*'+word.substring(i+1, wordLength);
                List<String> temp = allCombinations.getOrDefault(newWord, new ArrayList<>());
                temp.add(word);
                allCombinations.put(newWord,temp);
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()){
            Pair node = queue.poll();
            String word = node.word;
            int level = node.level;

            for(int i=0;i<wordLength;i++){
                String newWord = word.substring(0, i)+'*'+word.substring(i+1, wordLength);

                for(String adj : allCombinations.getOrDefault(newWord,new ArrayList<>())){
                    if(adj.equals(endWord)) return level+1;

                    if(!visited.add(adj)) continue;

                    queue.add(new Pair(adj, level+1));
                }
            }
        }

        return 0;
    }
}