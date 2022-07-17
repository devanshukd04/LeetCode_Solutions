class Solution {
    public int minimumOperations(int[] nums) {
        int a,b;
        if(nums.length==1 || nums.length==0){
            return 0;
        }
        if(nums.length==2){
            if(nums[0]==nums[1]){
                return 1;
            }
            return 0;
        }
        HashMap<Integer,Integer> map1=new HashMap<Integer,Integer>();
        List<Integer> list1=new ArrayList<Integer>();
        HashMap<Integer,Integer> map2=new HashMap<Integer,Integer>();
        List<Integer> list2=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                if(map2.containsKey(nums[i])){
                    int freq=map2.get(nums[i]);
                    map2.put(nums[i],freq+1);
                }
                else{
                    map2.put(nums[i],1);
                    list2.add(nums[i]);
                }
            }
            else{
                if(map1.containsKey(nums[i])){
                    int freq=map1.get(nums[i]);
                    map1.put(nums[i],freq+1);
                }
                else{
                    map1.put(nums[i],1);
                    list1.add(nums[i]);
                }
            }
        }
        int freq1=0,freq2=0,maxl1=0,maxl2=0,max2l1=0,max2l2=0;
        for(int i=0;i<list1.size();i++){
            if(i==0){
                maxl1=list1.get(i);
                freq1=map1.get(maxl1);
                maxl2=maxl1;
            }
            else{
                if(freq1<=map1.get(list1.get(i))){
                    freq1=map1.get(list1.get(i));
                    maxl2=maxl1;
                    maxl1=list1.get(i);
                }
                else if(maxl1==maxl2){
                    maxl2=list1.get(i);
                }
                else if(map1.get(maxl2)<map1.get(list1.get(i))){
                    maxl2=list1.get(i);
                }
            } 
        }
        for(int i=0;i<list2.size();i++){
            if(i==0){
                max2l1=list2.get(i);
                freq2=map2.get(max2l1);
                max2l2=max2l1;
            }
            else{
                if(freq2<=map2.get(list2.get(i))){
                    freq2=map2.get(list2.get(i));
                    max2l2=max2l1;
                    max2l1=list2.get(i);
                }
                else if(max2l1==max2l2){
                    max2l2=list2.get(i);
                }
                else if(map2.get(max2l2)<map2.get(list2.get(i))){
                    max2l2=list2.get(i);
                }
            } 
        }
        int count1=nums.length/2;
        int count2=nums.length%2==0?(nums.length/2):(nums.length/2+1);
        if(maxl1!=max2l1){
            return count1-map1.get(maxl1)+count2-map2.get(max2l1);
        }
        else{
            if(maxl1==maxl2 && max2l1==max2l2){
                return count1<count2?count1:count2;
            }
            if(maxl1==maxl2){
                return count1-map1.get(maxl1)+count2-map2.get(max2l2);
            }
            else if(max2l1==max2l2){
                return count1-map1.get(maxl2)+count2-map2.get(max2l1);
            }
            int sum1=count1-map1.get(maxl1)+count2-map2.get(max2l2);
            int sum2=count1-map1.get(maxl2)+count2-map2.get(max2l1);
            if(sum1<sum2){
                return sum1;
            }
            return sum2;
        }
    }
}