class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int index=0;
        List<String> ans=new ArrayList<String>();
        while(index<words.length){
            int size=0;
            int start=index;
            int end=index;
            int index1=index;
            while(index1<words.length){
                if(index1==start && size+words[index1].length()<=maxWidth){
                    size+=words[index1].length();
                    end=index1;
                }
                else if((1+size+words[index1].length())<=maxWidth){
                    size+=words[index1].length()+1;
                    end=index1;
                }
                else{
                    break;
                }
                index1++;
            }
            index=index1;
            if(index==words.length){
                lastLineHelper(ans,words,start,end,maxWidth);
            }
            else{
                helper(ans,words,start,end,maxWidth);         
            }
        }
        return ans;
    }
    public void lastLineHelper(List<String> ans, String[] words, int start, int end, int width){
        StringBuilder row=new StringBuilder();
        for(int i=start;i<=end;i++){
            width=width-words[i].length()-1;
            row.append(words[i]);
            if(width>=0){
                row.append(' ');   
            }
        }
        while(width>0){
            row.append(' ');
            width--;
        }
        ans.add(row.toString());
    }
    
    public void helper(List<String> ans, String[] words, int start, int end, int width){
        int wordCount=end-start;
        int remainingChar=width;
        
        for(int i=start;i<=end;i++){
            remainingChar-=words[i].length();
        }
        int space=0;
        int extraSpace=0;
        if(wordCount==0){
            extraSpace=remainingChar;
        }
        else{
            space=remainingChar/wordCount;
            extraSpace=remainingChar%wordCount;
        }
        StringBuilder row=new StringBuilder();
        for(int i=start;i<=end;i++){
            row.append(words[i]);
            for(int j=0;j<space && i!=end;j++){
                row.append(' ');
            }
            if(extraSpace!=0){
                row.append(' ');
                extraSpace--;
            }
        }
        while(extraSpace>0){
            row.append(' ');
            extraSpace--;
        }
        ans.add(row.toString());
    }
}