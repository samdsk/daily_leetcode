class Solution {
    public int numberOfBeams(String[] bank) {
        int sum = 0;
        int m = bank.length;

        int prev = 0;

        for(int i=0;i<m;i++){

            int count = 0;
            char[] row = bank[i].toCharArray();

            for(int j=0;j<row.length;j++){
                count += row[j] - '0';
            }

            if(count == 0)
                continue;

            sum += prev * count;            
            prev = count;
        }

        return sum;
    }
}