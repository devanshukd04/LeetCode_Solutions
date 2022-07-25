class Food{
    String food;
    int rating;
    Food(int rating,String food){
        this.food=food;
        this.rating=rating;
    }
}
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
                    foodRate.get(s1).equals(foodRate.get(s2))?s1.compareTo(s2):foodRate.get(s2)-foodRate.get(s1))
                );
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
// class FoodRatings {
//     HashMap<String,List<String>> cuisineTable=new HashMap<String,List<String>>();
//     HashMap<String,Integer> foodRate=new HashMap<String,Integer>();
//     HashMap<String,String> cuisineFood=new HashMap<String,String>();
//     HashMap<String,TreeSet<String>> maxRating=new HashMap<String,TreeSet<String>>();
//     public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//         for(int i=0;i<foods.length;i++){
//             foodRate.put(foods[i],ratings[i]);
//             cuisineFood.put(foods[i],cuisines[i]);
//             if(cuisineTable.containsKey(cuisines[i])){
//                 List<String> list=cuisineTable.get(cuisines[i]);
//                 list.add(foods[i]);
//                 cuisineTable.put(cuisines[i],list);
                
//                 maxRating.get(cuisines[i]).add(foods[i]);
//             }
//             else{
//                 cuisineTable.put(cuisines[i],list);
//                 maxRating.put(cuisines[i],new TreeSet<>((s1,s2)->
//                     s1.rating==s2.rating?(s1.food.compareTo(s2.food)):s2.rating-s1.rating));
//             }
//             Food curr=new Food(ratings[i],foods[i]);
//             maxRating.get(cuisines[i]).add(curr);
//         }
            
            
            
            
//             // System.out.println(maxRating.get(cuisines[0]).size()+" "+foods[i]+" "+foodRate.get(foods[i]));
//         // }
//         // System.out.println(maxRating.get(cuisines[0]).size()+" "+(maxRating.get(cuisines[0]).contains("zgochpey")));
//         // System.out.println(foods.length+" "+maxRating);
//     }
    
//     public void changeRating(String food, int newRating) {
//         String cuisine=cuisineFood.get(food);
//         TreeSet set=maxRating.get(cuisine);
        
//         set.remove(food);
//         foodRate.put(food,newRating);
//         set.add(food);
//     }
    
//     public String highestRated(String cuisine) {
//         return maxRating.get(cuisine).first();
//     }
// }
/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */