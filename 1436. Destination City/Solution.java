class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String,String> cities = new HashMap<>();

        for(List<String> city : paths){
            cities.put(city.get(0),city.get(1));
        }

        String next = paths.get(0).get(1);

        while(cities.containsKey(next)){
            next = cities.get(next);
        }

        return next;
    }
}