import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {            
            map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);            
        }

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            if(map.containsKey(guess.charAt(i))){
                if(secret.charAt(i)==guess.charAt(i)){
                    bulls++;
                    if(map.get(guess.charAt(i))<=0){
                        cows--;
                    }
                }else{
                    if(map.get(guess.charAt(i))>0){
                        cows++;
                    }
                }

                map.put(guess.charAt(i),map.get(guess.charAt(i))-1);
            }
        }

        return bulls+"A"+cows+"B";

    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1807", "7810"));
        System.out.println(new Solution().getHint("1123", "0111"));
    }
}