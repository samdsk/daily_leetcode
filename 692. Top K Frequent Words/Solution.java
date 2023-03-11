import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> output = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0)+1);
        }

        PriorityQueue<Entry<String,Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for(Entry<String,Integer> e : map.entrySet()){
            pq.offer(e);
            if(pq.size()>k) pq.poll();
        }

        while(!pq.isEmpty()){
            output.add(0,pq.poll().getKey());
        }

        return output;
    }
}