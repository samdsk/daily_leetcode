class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degrees = new int[n];

        for(int[] road : roads){
            degrees[road[0]]++;
            degrees[road[1]]++;
        }

        int max_1 = 0;
        int max_2 = 0;

        for(int d : degrees){
            if(d>max_1) {
                max_2 = max_1;
                max_1 = d;
            }
            else if(d>max_2 && d<max_1) max_2 = d;
        }

        int max_1_count = 0;
        int max_2_count = 0;

        for(int d : degrees){
            if(max_1 == d) max_1_count++;
            if(max_2 == d) max_2_count++;
        }

        if(max_1_count > 1){
            int edges = 0;
            for(int[] r : roads)
                if(degrees[r[0]] == max_1 && degrees[r[1]] == max_1) edges++;

            int max = max_1_count * (max_1_count - 1) /  2;

            return 2 * max_1 - (max == edges ? 1 : 0);

        }else{
            int edges = 0;
            for(int[] r : roads){
                if(degrees[r[0]] == max_1 && degrees[r[1]] == max_2) edges++;
                if(degrees[r[0]] == max_2 && degrees[r[1]] == max_1) edges++;
            }

            return  max_1 + max_2 - (max_2_count == edges ? 1 : 0);
        }

    }
}