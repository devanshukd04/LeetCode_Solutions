class Solution {
    public int minimizeXor(int num1, int num2) {
        if(num1==num2){
            return num1;
        }
        int a=num1;
        int i=0;
        
        int b=0;
        while(num2>0){
            if((num2&1)==1){
                b++;
            }
            num2=num2>>1;
        }
        System.out.println(b);
        
        List<Integer> list=new ArrayList<Integer>();
        while(a>0){
            if(b>0){
                if((a&1)==1){
                    list.add(1);
                } 
                else{
                    list.add(0);   
                }
            }
            a=a>>1;
        }
        int ans=0;
        int temp2=1;
        System.out.println(list);
        for(int j=list.size()-1;j>=0;j--){
            if(list.get(j)==1 && b>0){
                ans=ans|1;
                b--;
            }
            if(j>0){
                ans=ans<<1;   
            }
            temp2=temp2<<1;
        }
        System.out.println(ans+" "+b);
        
        
        int temp=1;
        i=0;
        while(b>0){
            
            if(i<list.size() && list.get(i)==0){
                ans=ans|temp;
                b--;
            }
            if(i==list.size()){
                break;
            }
            i++;
            temp=temp<<1;
            
        }
        
        if(b>0){
            while(b>0){
                ans=ans|temp2;
                temp2=temp2<<1;
                b--;
            }
        }
        
        return ans;
    }
}