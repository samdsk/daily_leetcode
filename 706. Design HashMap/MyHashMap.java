import java.util.LinkedList;

class MyHashMap {
    private final int size = 100000;
    private final int hash_multiplication = 12582917;
    private record Pair(int key, int value) {}
    private LinkedList<Pair>[] keys = new LinkedList[size];;
    
    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Pair> node = keys[index];
        remove(key);

        if(node == null){
            LinkedList<Pair> temp = new LinkedList<>();
            temp.add(new Pair(key, value));
            keys[index] = temp;
        }else{
            node.addFirst(new Pair(key, value));
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        LinkedList<Pair> node = keys[index];

        if(node == null) return -1;
        
        for(Pair p : node){
            if(p.key() == key) return p.value();
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Pair> node = keys[index];

        if(node != null){
            for(Pair p : node){
                if(p.key() == key) node.remove(p);
            }
        }
    }

    private int hash(int key){
        return (int)((long) key * hash_multiplication % size);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */