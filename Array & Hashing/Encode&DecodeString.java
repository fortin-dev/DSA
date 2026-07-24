class Solution {

    public String encode(List<String> strs) {
        String r= "";
        for (String s: strs){
            String len = Integer.toString(s.length());
            r+= len+"#"+s;
        }
        return r;
    }


    public List<String> decode(String str) {
        List<String> r = new ArrayList<>();
        int i = 0;
        while(i!=str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            r.add(str.substring(j+1,j+len+1));
            i=j+1+len;
        }
        return r;
    }
}
