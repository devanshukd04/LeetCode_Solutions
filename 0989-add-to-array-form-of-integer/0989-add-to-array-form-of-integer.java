class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans=new ArrayList<Integer>();
        int carry=0;
        for(int i=num.length-1;i>=0;i--){
            int digit=k%10;
            k/=10;
            int curr=num[i]+digit+carry;
            carry=0;
            if(curr>=10){
                carry=1;
            }
            ans.add(curr%10);
        }
        while(k>0){
            int curr=k%10+carry;
            k/=10;
            carry=0;
            if(curr>=10){
                carry=1;
            }
            ans.add(curr%10);
        }
        if(carry==1){
            ans.add(carry);
        }
        for(int i=0;i<ans.size()/2;i++){
            int temp=ans.get(i);
            ans.set(i,ans.get(ans.size()-1-i));
            ans.set(ans.size()-1-i,temp);
        }
        return ans;
    }
}