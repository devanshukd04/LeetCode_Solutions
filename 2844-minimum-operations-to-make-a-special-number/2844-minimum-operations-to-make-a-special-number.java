class Solution {
    public int minimumOperations(String num) {
        StringBuilder reversedNum = new StringBuilder(num);
        reversedNum.reverse();
        
        int is5 = 0;
        int is0 = 0;
        int count = 0;
        
        for (int i = 0; i < reversedNum.length(); i++) {
            char digit = reversedNum.charAt(i);
            
            if (digit == '5') {
                if (is0 == 1) {
                    return i - 1;
                }
                is5 = 1;
            } else if (digit == '0') {
                if (is0 == 1) {
                    return i - 1;
                }
                is0 = 1;
            } else if (digit == '7' || digit == '2') {
                if (is5 == 1) {
                    return i - 1;
                }
            }
        }
        
        return (int) (reversedNum.length() - num.chars().filter(ch -> ch == '0').count());
    }
}