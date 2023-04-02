import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];

        int m = potions.length;
        int max = potions[m-1];

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long minPotion = (long) Math.ceil((1.0 * success) / spell);

            if(minPotion > max){
                res[i] = 0;
                continue;
            }

            int index = search(potions, (int) minPotion);
            res[i] = m - index;
        }

        return res;
    }

    private int search(int potions[], int spell){
        int left = 0;
        int right = potions.length;

        while(left<right){
            int mid = left + (right-left)/2;

            if(potions[mid]<spell) left = mid+1;
            else right = mid;
        }
        return left;
    }
}