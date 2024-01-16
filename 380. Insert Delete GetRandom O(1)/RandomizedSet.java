import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

class RandomizedSet {
    private Set<Integer> set;
    private ArrayList<Integer> list;
    Random r = new Random();

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)) return false;

        set.add(val);
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val)) return false;
        set.remove(val);
        list.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        int key = r.nextInt(set.size());
        return list.get(key);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */