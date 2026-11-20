class Solution {
    public int minOperations(String s) {
        boolean sorted=true;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)>s.charAt(i)){
                sorted=false;
            }
       }
        if(sorted){
            return 0;
        }
       if(s.length()==2){
        return -1;
       }
       int c[]=new int[26];
       for(char ch:s.toCharArray()){
            c[ch-'a']++;
       }
       char first=s.charAt(0);
       char last=s.charAt(s.length()-1);
       int i=0;
       while(c[i]==0) i++;
       char min=(char)('a'+i);
       int minfreq=c[i];
       int j=25;
       while(c[j]==0) j--;
       char max=(char)('a'+j);
       int maxfreq=c[j];
       if(min==first || max==last) return 1;
       if(first==max && maxfreq==1 && last==min && minfreq==1) return 3;
       return 2;
    }
}