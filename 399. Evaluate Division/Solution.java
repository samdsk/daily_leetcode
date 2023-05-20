import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind dsu = new UnionFind();

        int i = 0;
        for(List<String> e : equations){
            dsu.union(e.get(0), e.get(1), values[i++]);
        }

        double[] ans = new double[queries.size()];

        i = 0;
        for(List<String> q : queries){
            ans[i++] = dsu.get((q.get(0)), q.get(1));
        }

        return ans;
    }

    public class UnionFind{
        private Map<String,String> parent = new HashMap<>();
        private Map<String,Integer> rank = new HashMap<>();
        private Map<String,Double> value = new HashMap<>();

        public double get(String x,String y){
            if(!parent.containsKey(x) || !parent.containsKey(y)) return -1.0;
            if(!find(x).equals(find(y))) return -1.0;

            return getValue(y) / getValue(x);
        }

        private double getValue(String x) {
            double res = 1.0;
            while(!x.equals((parent.get(x)))){
                res *= value.getOrDefault(x,1.0);
                x = parent.get(x);
            }

            return res;
        }

        public String find(String x){
            parent.computeIfAbsent(x, ignored -> x);
            if(parent.get(x).equals(x)) return x;
            return find(parent.get(x));
        }

        public void union(String x, String y, double xy){
            String xset = find(x);
            String yset = find(y);


            if(xset != yset){
                int rankX = rank.getOrDefault(xset, 1);
                int rankY = rank.getOrDefault(yset, 1);

                double valueX = getValue(x);
                double valueY = getValue(y);

                if(rankX >= rankY){
                    rank.put(xset,rankX+rankY);
                    valueY = valueX * xy / valueY;
                    parent.put(yset,xset);
                    value.put(yset,valueX);
                }else{
                    rank.put(yset,rankX+rankY);
                    valueX = valueY / xy / valueX;
                    parent.put(xset,yset);
                    value.put(xset,valueX);
                }

            }
        }

    }
}