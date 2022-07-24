class Solution {
    private StringBuilder sumResults(ArrayList<ArrayList<Integer>> results){
        ArrayList<Integer> answer=new ArrayList<>(results.get(results.size()-1));
        ArrayList<Integer> newAnswer=new ArrayList<>();
        
        for(int j=0;j<results.size()-1;++j){
            ArrayList<Integer> result=new ArrayList<>(results.get(j));
            newAnswer=new ArrayList<>();
            int carry=0;
            
            for(int i=0;i<answer.size() || i<result.size();++i){
                int digit1=i<result.size()?result.get(i):0;
                int digit2=i<answer.size()?answer.get(i):0;
                
                int sum=digit1+digit2+carry;
                carry=sum/10;
                newAnswer.add(sum%10);
            }
            if(carry!=0){
                newAnswer.add(carry);
            }
            answer=newAnswer;
        }
        
        StringBuilder finalAnswer=new StringBuilder();
        for(int digit:answer){
            finalAnswer.append(digit);
        }
        return finalAnswer;
    } 
    ArrayList<Integer> multiplyOneDigit(StringBuilder firstNumber, char secondNumberDigit, int numZeros){
        ArrayList<Integer> currentResult=new ArrayList<>();
        for(int i=0;i<numZeros;++i){
            currentResult.add(0);
        }
        int carry=0;
        
        for(int i=0;i<firstNumber.length();++i){
            char firstNumberDigit=firstNumber.charAt(i);
            int multiplication=(secondNumberDigit-'0')*(firstNumberDigit-'0')+carry;
            carry=multiplication/10;
            currentResult.add(multiplication%10);
        }
        
        if(carry!=0){
            currentResult.add(carry);
        }
        return currentResult;
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        StringBuilder firstNumber=new StringBuilder(num1);
        StringBuilder secondNumber=new StringBuilder(num2);
        
        firstNumber.reverse();
        secondNumber.reverse();
        
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        for(int i=0;i<secondNumber.length();++i){
            results.add(multiplyOneDigit(firstNumber,secondNumber.charAt(i),i));
        }
        
        StringBuilder answer=sumResults(results);
        answer.reverse();
        return answer.toString();
    }
}