class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        for(int num:nums){
            int temp=num;
            List<Integer> temp1=new ArrayList<Integer>();
            while(temp>0){
                temp1.add(temp%10);
                temp/=10;
            }
            for(int i=temp1.size()-1;i>=0;i--){
                list.add(temp1.get(i));
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}