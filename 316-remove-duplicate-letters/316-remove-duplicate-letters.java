class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack=new Stack<Integer>();
        Set<Integer> set=new HashSet<Integer>();
        int a;
        Character c;
        String b="";
        a=s.charAt(0)-'a';
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<26;i++){
            a=s.lastIndexOf((char)('a'+i)) ;
            list.add(a);
        }
        for(int i=0;i<s.length();i++){
            a=s.charAt(i)-'a';
            if(stack.isEmpty()){
                stack.push(a);
                set.add(a);
            }
            else if(stack.peek()<a && !set.contains(a)){
                stack.push(a);
                set.add(a);
            }
            else if(stack.peek()>a && !set.contains(a)){
                while(!stack.isEmpty() && i<=list.get(stack.peek()) && stack.peek()>=a){
                    set.remove(stack.pop());
                }
                stack.push(a);
                set.add(a);
            }
        }
        while(!stack.isEmpty()){
            a=stack.pop();
            c=(char)(a+'a');
            b=Character.toString(c)+b;
        }
        return b;
    }
}