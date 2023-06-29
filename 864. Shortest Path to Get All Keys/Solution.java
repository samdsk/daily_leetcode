import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    // might need comparable interface
    private class Pair<T1, T2> {
    T1 key;
    T2 value;

    public Pair(T1 k, T2 v){
        key = k;
        value = v;
    }
}

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        Queue<int[]> queue = new LinkedList<>();

        int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        Map<Integer,Set<Pair<Integer,Integer>>> visited = new HashMap<>();

        Set<Character> keySet = new HashSet<>();
        Set<Character> lockSet = new HashSet<>();

        int allKeys = 0;

        int startR = -1, startC = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cell = grid[i].charAt(j);

                if(cell >= 'a' && cell <= 'f'){
                    allKeys += (1 << (cell - 'a'));
                    keySet.add(cell);
                }

                if(cell >= 'A' && cell <= 'F'){
                    lockSet.add(cell);
                }

                if(cell == '@'){
                    startR = i;
                    startC = j;
                }
            }
        }

        queue.offer(new int[]{startR,startC,0,0});
        visited.put(0,new HashSet<>());
        visited.get(0).add(new Pair<>(startR,startC));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int currentR = current[0];
            int currentC = current[1];

            int keys = current[2];
            int dist = current[3];

            for(int[] move : moves){
                int newR = currentR + move[0];
                int newC = currentC + move[1];

                if(newR >= 0 && newR < m
                    && newC >= 0 && newC < n
                    && grid[newR].charAt(newC) != '#'){
                        char cell = grid[newR].charAt(newC);
                        if(keySet.contains(cell)){
                            if(((1<<(cell - 'a')) & keys) != 0){
                                continue;
                            }

                            int newKeys = (keys | (1<<(cell - 'a')));
                            if(newKeys == allKeys) return dist + 1;

                            visited.putIfAbsent(newKeys, new HashSet<>());
                            visited.get(newKeys).add(new Pair<>(newR,newC));
                            queue.offer(new int[]{newR,newC,newKeys,dist+1});
                        }

                        if(lockSet.contains(cell) && ((keys & (1 << (cell - 'A'))) == 0)){
                            continue;
                        }

                        else if(!visited.get(keys).contains(new Pair<>(newR,newC))){
                            visited.get(keys).add(new Pair<>(newR,newC));
                            queue.offer(new int[]{newR,newC,keys,dist+1});
                        }

                }
            }
        }

        return -1;

    }
}