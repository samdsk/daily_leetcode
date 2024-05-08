class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = score.length;

        for(int i=0;i<n;i++){
            map.put(score[i], i);
        }

        String[] ans = new String[n];

        Arrays.sort(score);

        for(int i=n-1;i>=0;i--){
            int index = map.get(score[i]);

            if(i==n-1)
                ans[index] = "Gold Medal";
            if(i==n-2)
                ans[index] = "Silver Medal";
            if(i==n-3)
                ans[index] = "Bronze Medal";
            if(i<n-3)
                ans[index] = ""+(n-i);
        }
        // 10 9 8 4 3
        return ans;
    }
}