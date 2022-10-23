class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int initial1=(event1[0].charAt(0)-'0')*10+(event1[0].charAt(1)-'0');
        int initial2=(event2[0].charAt(0)-'0')*10+(event2[0].charAt(1)-'0');
        int min1=(event1[0].charAt(3)-'0')*10+(event1[0].charAt(4)-'0');
        int min2=(event2[0].charAt(3)-'0')*10+(event2[0].charAt(4)-'0');
        int end1=(event1[1].charAt(0)-'0')*10+(event1[1].charAt(1)-'0');
        int end2=(event2[1].charAt(0)-'0')*10+(event2[1].charAt(1)-'0');
        int endmin1=(event1[1].charAt(3)-'0')*10+(event1[1].charAt(4)-'0');
        int endmin2=(event2[1].charAt(3)-'0')*10+(event2[1].charAt(4)-'0');
        if(initial1<initial2){
            System.out.println(end1+" "+initial2+" "+endmin1+" "+min2);
            if(end1==initial2 && endmin1>=min2){
                return true;
            }
            else if(end1>initial2){
                return true;
            }
            return false;
        }
        else if(initial1==initial2){
            return true;
        }
        else{
            if(end2==initial1 && endmin2>=min1){
                return true;
            }
            else if(end2>=initial1){
                return true;
            }
            return false;
        }
    }
}