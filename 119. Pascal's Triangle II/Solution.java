import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int n = rowIndex;
        long res = 1;

        for (int i = 0; i <= n; i++) {
            ans.add((int) res);
            res = (res * (n-i)) / (i+1);
        }

        return ans;
    }
}