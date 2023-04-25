import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

class SmallestInfiniteSet {
    private SortedSet<Integer> set;
    private int min;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        min = 1;
    }

    public int popSmallest() {

        if(!set.isEmpty()){
            int ans = set.first();
            set.remove(ans);
            return ans;
        }
        return min++;
    }

    public void addBack(int num) {
        if(min <= num || set.contains(num)) return;
        set.add(num);
    }
}
