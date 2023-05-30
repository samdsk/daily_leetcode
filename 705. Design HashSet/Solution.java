class MyHashSet {
    final boolean[] set;
    final int SIZE = 1_000_001;
    public MyHashSet() {
        set = new boolean[SIZE];
    }

    public void add(int key) {
        if(set[key]) return;
        set[key] = true;
    }

    public void remove(int key) {
        if(set[key]) set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}

// class MyHashSet extends HashSet{}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */