class Solution {
    public String greatestLetter(String s) {
        String[] a={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] b={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for(int i=25;i>=0;i--){
            if(s.contains(a[i])){
                if(s.contains(b[i])){
                    return a[i];
                }
            }
        }
        String c="";
        return c;
    }
}