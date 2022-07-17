class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> s1=new Stack<Character>();
        StringBuilder a1=new StringBuilder();
        ArrayList<Integer> a2=new ArrayList<Integer>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                s1.push(s.charAt(i));
                a2.add(i);
            }
            else if(s.charAt(i)==')'){
                if(!s1.isEmpty()){
                    if(s1.peek()=='('){
                        s1.pop();
                        a2.remove(a2.size()-1);
                    }
                    else{
                        a2.add(i);
                    }
                }
                else{
                    a2.add(i);
                }
            }
        }
        for(int i=0;i<s.length();i++){
            if(!a2.contains(i)){
                a1.append(s.charAt(i));
            }
        }
        return new String(a1);
    }
}