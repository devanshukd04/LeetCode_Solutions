class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack=new Stack<Integer>();
        Set<Integer> set=new HashSet<Integer>();
        
        int[] charEnd=new int[26];
        Arrays.fill(charEnd,-1);
        for(int i=0;i<s.length();i++){
            charEnd[s.charAt(i)-'a']=i;
        }
        
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i)-'a';
            if(stack.isEmpty()){
                stack.push(ch);
                set.add(ch);
            }
            else if(stack.peek()<ch && !set.contains(ch)){
                stack.push(ch);
                set.add(ch);
            }
            else if(stack.peek()>ch && !set.contains(ch)){
                while(!stack.isEmpty() && i<charEnd[stack.peek()] && stack.peek()>ch){
                    set.remove(stack.pop());
                }
                stack.push(ch);
                set.add(ch);
            }
        }
        
        StringBuffer ans=new StringBuffer();
        while(!stack.isEmpty()){
            int ch=stack.pop();
            ans.append((char)(ch+'a'));
        }
        ans.reverse();
        
        return ans.toString();
    }
}