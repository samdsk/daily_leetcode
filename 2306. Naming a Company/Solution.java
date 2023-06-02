import java.util.HashSet;
import java.util.Set;

class Solution {
    public long distinctNames(String[] ideas) {
        final HashSet<String>[] group = new HashSet[26];

        for (int i = 0; i < 26; i++) {
            group[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            group[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        long ans = 0;

        for (int i = 0; i < 25; i++) {
            for (int j = i+1; j < 26; j++) {
                long mutual = 0;
                for(String ideaA : group[i]){
                    if(group[j].contains(ideaA)) mutual++;
                }

                ans += 2 * (group[i].size() - mutual) * (group[j].size() - mutual);
            }
        }

        return ans;
    }
}