class FoodRatings {
    HashMap<String,Integer> foodRate=new HashMap<String,Integer>();
    HashMap<String,String> cuisineFood=new HashMap<String,String>();
    HashMap<String,TreeSet<String>> maxRating=new HashMap<String,TreeSet<String>>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0;i<foods.length;i++){
            foodRate.put(foods[i],ratings[i]);
            cuisineFood.put(foods[i],cuisines[i]);
            
            if(maxRating.containsKey(cuisines[i])){
                maxRating.get(cuisines[i]).add(foods[i]);
            }
            else{
                maxRating.put(cuisines[i],new TreeSet<String>((s1,s2)->
                {
                    if(foodRate.get(s1).equals(foodRate.get(s2))){
                        return s1.compareTo(s2);
                    }
                    else{
                        return foodRate.get(s2)-foodRate.get(s1);
                    }
                }));         
                maxRating.get(cuisines[i]).add(foods[i]);
            }
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine=cuisineFood.get(food);
        TreeSet set=maxRating.get(cuisine);
        set.remove(food);
        foodRate.put(food,newRating);
        set.add(food);
    }
    
    public String highestRated(String cuisine) {
        return maxRating.get(cuisine).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
