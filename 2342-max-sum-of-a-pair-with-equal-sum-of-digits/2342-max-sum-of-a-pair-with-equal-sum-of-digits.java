class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        HashSet<Integer> set=new HashSet<Integer>();
        int max=-1;
        Arrays.sort(nums); 
        for(int num:nums){
            int a=num;
            int dsum=0;
            while(a>0){
                dsum+=a%10;
                a/=10;
            }
            
            if(map.containsKey(dsum)){
                List<Integer> list1=map.get(dsum);
                list1.add(num);
                map.put(dsum,list1);
                if(!list.contains(dsum)){
                    list.add(dsum);   
                }
            }
            else{
                List<Integer> list1=new ArrayList<Integer>();
                list1.add(num);
                map.put(dsum,list1);
                set.add(dsum);
            }
        }
        System.out.println(map+" "+set+" "+list);
        for(int num:list){
            int sum=0;
            List<Integer> list1=map.get(num);
            int size=list1.size();
            sum=list1.get(size-1)+list1.get(size-2);
            max=sum>max?sum:max;
        }
        return max;
    }
}