class Solution {
    public int minChanges(String s) {
        char currentChar=s.charAt(0);
        int consecutive=0;
        int matching=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==currentChar){
                consecutive++;
                continue;
            }
            else if(consecutive%2==0){
                consecutive=1;
            }
            else{
                consecutive=0;
                matching++;
            }
            currentChar=s.charAt(i);
        }
        return matching;
    }
}