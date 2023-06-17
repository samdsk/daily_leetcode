import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Map<Integer,Integer> dp = new HashMap<>();

        Arrays.sort(arr2);

        int n = arr2.length;

        dp.put(-1,0);

        for (int i = 0; i < arr1.length; i++) {
            Map<Integer,Integer> newDp = new HashMap<>();
            for(int prev : dp.keySet()){
                if(arr1[i]>prev){
                    newDp.put(
                            arr1[i],
                            Math.min(newDp.getOrDefault(arr1[i], Integer.MAX_VALUE),
                                dp.get(prev)
                            )
                        );
                }

                int idx = bisectRight(arr2,prev);
                if(idx < n){
                    newDp.put(
                            arr2[idx],
                            Math.min(newDp.getOrDefault(arr2[idx], Integer.MAX_VALUE),
                               1 + dp.get(prev)
                            )
                        );
                }

            }
            dp = newDp;
        }

        int ans = Integer.MAX_VALUE;

        for(int v : dp.values()){
            ans = Math.min(ans, v);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int bisectRight(int[] arr, int prev) {
        int left = 0, right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid]<= prev) left = mid + 1;
            else right = mid;
        }
        return left;
    }

}