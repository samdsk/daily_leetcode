import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        
        helper(new ArrayList<>(List.of(1)), numRows);

        return ans;
    }

    private void helper(List<Integer> prev, int rows){
        ans.add(prev);
        int size = prev.size();

        if(!(size<rows)) return;

        size++;
        List<Integer> current = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if(i-1<0 || i+1>=size) 
                current.add(1);
            else
                current.add(prev.get(i-1)+prev.get(i));
            
        }

        helper(current, rows);
    }
}