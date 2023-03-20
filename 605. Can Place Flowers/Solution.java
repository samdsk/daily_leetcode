class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        
        for(int i=0;i<flowerbed.length; i++){

            if(flowerbed[i]==0){
                boolean leftOk = i == 0 || flowerbed[i-1] == 0;
                boolean rightOk = i == flowerbed.length-1 || flowerbed[i+1] == 0;

                if(leftOk && rightOk){
                    flowerbed[i] = 1;
                    max++;
                }
            }
        }

        return max>=n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
    }
}