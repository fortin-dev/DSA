class Solution {
    public int romanToInt(String s) {
        int result = 0;
        String sym = "IVXLCDM";
        int val = new int[]{1,5,10,50,100,500,1000};
        for(int i =0; i<s.length ; i++){
            for(int j =0; j<7 ; j++){
                // if(sym[j] == s[i]){
                //     if(s[i]=='I' && s[i+1]=='V'){
                //         result+=4;
                //     }
                //     else if(s[i]=='I' && s[i+1]=='X'){
                //         result+=9;
                //     }
                //     else if(s[i]=='X' && s[i+1]=='L'){
                //         result+=40;
                //     }
                //     else if(s[i]=='X' && s[i+1]=='C'){
                //         result+=90;
                //     }
                //     else if(s[i]=='C' && s[i+1]=='D'){
                //         result+=400;
                //     }
                //     else(s[i]=='C' && s[i+1]=='M'){
                //         result+=900;
                //     }
                //     result+=val[j];
                // }
            }
        }
        return result;
    }
}