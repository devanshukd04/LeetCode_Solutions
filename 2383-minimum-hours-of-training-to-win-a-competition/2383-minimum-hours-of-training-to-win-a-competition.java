class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans=0;
        int energysum=0;
        int initialenergy=initialExperience;
        for(int num:energy){
            energysum+=num;
        }
        if(initialEnergy<(energysum+1)){
            ans+=energysum-initialEnergy+1;
            initialEnergy=energysum+1;
        }
        int i=0;
        int add=0;
        int experienceadd=0;
        while(i<experience.length){
            if(initialExperience<=experience[i]){
                add=Math.max(add,experience[i]-initialExperience+1);
            }
            initialEnergy-=energy[i];
            initialExperience+=experience[i];
            ++i;
        }
        ans+=add;
        return ans;
    }
}