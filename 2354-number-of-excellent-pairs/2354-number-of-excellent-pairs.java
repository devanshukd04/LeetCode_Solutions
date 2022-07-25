class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<Integer>();
        List<Integer> list=new ArrayList<Integer>();
        long ans=0;
        boolean flag;
        for(int num:nums){
            if(!set.contains(num)){
                set.add(num);
                int count=0;
                while(num>0){
                    count+=num&1;
                    num>>=1;
                }
                list.add(count);
            }
        }
        Collections.sort(list);
        int size=list.size();
        for(int i=0;i<list.size();i++){
            flag=false;
            int search=(k-list.get(i))>0?(k-list.get(i)):0;
            if(search<=list.get(i)){
                flag=true;
            }
            int index=binarySearch(list,search,i);
            if(index!=-1){
                ans+=flag?2*(size-index)-1:2*(size-index);
            }
        }
        return ans;
    }
    public int binarySearch(List<Integer> nums, int search,int i){
        int start=i;
        int end=nums.size()-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums.get(mid)>=search){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}