class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        //Variable to store ans
        int ans=0;
        int energysum=0;
        //Variable to store the total energy require
        for(int num:energy){
            energysum+=num;
        }
        //If initialEnergy is less than totalEnergy require so adding the difference among the two energy + 1 to initalEnergy
        if(initialEnergy<(energysum+1)){
            ans+=energysum-initialEnergy+1;
            initialEnergy=energysum+1;
        }
        int i=0;
        //Variable add keeps track of the experience require to be added to initialExperience
        int add=0;
        while(i<experience.length){
            //If initialExperience is less then the require experience than computing the differnce among the two experiences + 1, and storing the max of this computed value and value in variable add in add
            if(initialExperience<=experience[i]){
                add=Math.max(add,experience[i]-initialExperience+1);
            }
            //Decreasing energy
            initialEnergy-=energy[i];
            //Adding experience
            initialExperience+=experience[i];
            ++i;
        }
        //Adding the required experience to be added to ans variable
        ans+=add;
        return ans;
    }
}