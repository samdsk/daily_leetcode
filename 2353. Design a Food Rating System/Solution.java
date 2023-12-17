import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FoodRatings {
    private record Food(String food, int rating) implements Comparable<Food> {

        @Override
        public int compareTo(Food o) {
            int c = Integer.compare(rating, o.rating);
            if(c == 0){
                return o.food.compareTo(this.food);
            }else return c;
        }
        
    }

    private final Map<String,PriorityQueue<Food>> data = new HashMap<>();
    private final Map<String,String> foodToCuisine = new HashMap<>();
    private final Map<String,Integer> foodToRating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = ratings.length;

        for (int i = 0; i < n; i++) {
            Food f = new Food(foods[i], ratings[i]);
            
            data.computeIfAbsent(cuisines[i], x -> new PriorityQueue<>(Collections.reverseOrder()));

            data.get(cuisines[i]).add(f);

            foodToCuisine.putIfAbsent(foods[i], cuisines[i]);
            foodToRating.putIfAbsent(foods[i], ratings[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        if(!foodToCuisine.containsKey(food)) return;

        String cuisine = foodToCuisine.get(food);
        foodToRating.put(food,newRating);

        data.get(cuisine).add(new Food(food, newRating));
        
    }
    
    public String highestRated(String cuisine) {
        
        Food max = data.get(cuisine).peek();

        while(foodToRating.get(max.food) != max.rating){
            data.get(cuisine).poll();
            max = data.get(cuisine).peek();
        }
        
        return max.food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */