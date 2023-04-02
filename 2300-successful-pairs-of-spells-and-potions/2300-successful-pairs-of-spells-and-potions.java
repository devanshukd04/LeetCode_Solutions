class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans=new int[spells.length];
        for(int i=0;i<spells.length;i++){
            int start=0;
            int end=potions.length-1;
            int index=potions.length;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(((long)potions[mid]*(long)spells[i])>=success){
                    index=mid;
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            ans[i]=potions.length-index;
        }
        return ans;
    }
}