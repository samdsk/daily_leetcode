import java.util.TreeMap;

class SnapshotArray {
    int count = 0;
    TreeMap<Integer,Integer>[] history;

    public SnapshotArray(int length) {
        history = new TreeMap[length];

        for (int i = 0; i < length; i++) {
            history[i] = new TreeMap<>();
            history[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        history[index].put(count, val);
    }

    public int snap() {
        return count++;
    }

    public int get(int index, int snap_id) {
        return history[index].floorEntry(snap_id).getValue();
    }
}