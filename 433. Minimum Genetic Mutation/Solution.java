
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> bankSet = new HashSet<>();

        for(String s : bank) bankSet.add(s);
        if(!bankSet.contains(endGene)) return -1;

        queue.add(startGene);
        visited.add(startGene);

        int steps = 0;
        char[] validChars = new char[]{'A','C','G','T'};

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                String node = queue.poll();
                if(node.equals(endGene)) return steps;

                for(char c : validChars){
                    char[] charArray = node.toCharArray();
                    for (int j = 0; j < node.length(); j++) {
                        char temp = charArray[j];
                        charArray[j] = c;
                        String temp_str = String.valueOf(charArray);

                        if(visited.add(temp_str) && bankSet.contains(temp_str)){
                            queue.add(temp_str);
                        }

                        charArray[j] = temp;
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}