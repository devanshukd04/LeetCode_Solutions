class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
            int temp=num;
            int temp1=0;
            while(temp>0){
                int unit=temp%10;
                temp1=temp1*10+unit;
                temp/=10;
            }
            set.add(temp1);
        }
        return set.size();
    }
}