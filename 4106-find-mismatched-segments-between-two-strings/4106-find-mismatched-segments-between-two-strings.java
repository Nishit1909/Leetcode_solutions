class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        String a="";
        String b="";
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                a=a+s1.charAt(i);
                b=b+s2.charAt(i);
            }
            else if(s1.charAt(i)==s2.charAt(i)){
                if(!a.isEmpty()){
                    temp.add(a);
                    temp.add(b);
                    res.add(new ArrayList<>(temp));
                }
                a="";
                b="";
                temp.clear();
            }
        }
        if(!a.isEmpty()){
            temp.add(a);
            temp.add(b);
            res.add(new ArrayList<>(temp));
        }
        return res;
        
    }
}