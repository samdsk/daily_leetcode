class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<matches.length;i++){
            map.computeIfAbsent(matches[i][0], (x) -> 0);
            map.put(matches[i][1],map.getOrDefault(matches[i][1],0)+1);
        }

        ArrayList<Integer> notLost = new ArrayList<>();
        ArrayList<Integer> lostOnce = new ArrayList<>();

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() == 0)
                notLost.add(e.getKey());
            if(e.getValue() == 1)
                lostOnce.add(e.getKey());
        }
        
        Comparator<Integer> intComp = Comparator.comparing(Integer::intValue);

        notLost.sort(intComp);
        lostOnce.sort(intComp);

        return List.of(notLost,lostOnce);
    }
}