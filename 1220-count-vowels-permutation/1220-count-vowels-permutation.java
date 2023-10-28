class Solution {
    int mod=(int)1e9+7;
    public int countVowelPermutation(int n) {
        Map<Character,List<Character>> map=new HashMap<>();
        
        List<Character> list1=new ArrayList<>();
        list1.add('a');
        list1.add('e');
        list1.add('i');
        list1.add('o');
        list1.add('u');
        map.put('s',list1);
        
        List<Character> list2=new ArrayList<>();
        list2.add('e');
        map.put('a',list2);
        
        List<Character> list3=new ArrayList<>();
        list3.add('a');
        list3.add('i');
        map.put('e',list3);
        
        List<Character> list4=new ArrayList<>();
        list4.add('a');
        list4.add('e');
        list4.add('o');
        list4.add('u');
        map.put('i',list4);
        
        List<Character> list5=new ArrayList<>();
        list5.add('i');
        list5.add('u');
        map.put('o',list5);
        
        List<Character> list6=new ArrayList<>();
        list6.add('a');
        map.put('u',list6);
        
        int[][] dp=new int[n+1][6];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        
        return helper(map,dp,n,0);
    }
    
    public int helper(Map<Character,List<Character>> map, int[][] dp, int n, int prev){
        if(n==0){
            return 1;
        }
        
        if(dp[n][prev]!=-1){
            return dp[n][prev];
        }
        
        char key=getChar(prev);
        int ans=0;
        
        for(Character ch:map.get(key)){
            int newPrev=getCharNum(ch);
            ans=(ans+helper(map,dp,n-1,newPrev))%mod;
        }
        
        return dp[n][prev]=ans;
    }
    public char getChar(int prev){
        if(prev==0){
            return 's';
        }
        else if(prev==1){
            return 'a';
        }
        else if(prev==2){
            return 'e';
        }
        else if(prev==3){
            return 'i';
        }
        else if(prev==4){
            return 'o';
        }
        else{
            return 'u';
        }
    }
    public int getCharNum(char ch){
        if(ch=='s'){
            return 0;
        }
        else if(ch=='a'){
            return 1;
        }
        else if(ch=='e'){
            return 2;
        }
        else if(ch=='i'){
            return 3;
        }
        else if(ch=='o'){
            return 4;
        }
        else{
            return 5;
        }
    }
}