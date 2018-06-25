  static String[] c = new String[]{"`1234567890-=~!@#$%^&*()_+","qwertyuiop[]\\QWERTYUIOP{}|","asdfghjkl;'ASDFGHJKL:\"","zxcvbnm,./ZXCVBNM<>?"};
static void f(String s){    
        String[] r = new String[]{"","","","",""};
        int[] d = new int[]{0,0,0,0};
        int leastRow = 0;
        for(int i = 0; i<s.length(); i++){
           String subString = s.substring(i,i+1);
           if(r[rowNumber(subString)].contains(subString)){
               d[rowNumber(subString)]++;
           }
           else{
               r[rowNumber(subString)]+=subString;
           }
           leastRow = rowNumber(subString);
        }
        for(int i=0; i<4; i++){
            if((r[i].length() + d[i] < r[leastRow].length() + d[leastRow]
                    || (r[i].length() + d[i] == r[leastRow].length() + d[leastRow]
                            &&( d[i] > d[leastRow] || i < leastRow )))
                    &&(r[i].length()> 0)) 
                leastRow=i;
        }     

        char[] resultRow = new char[26];
        for (int i = 0; i < r[leastRow].length(); i++) {
            resultRow[c[leastRow].indexOf(r[leastRow].charAt(i))] = r[leastRow].charAt(i);           
        } 
        for(char c: resultRow){
            if(c > 0)
                r[4]+=c; 
        }
        System.out.print(String.valueOf(r[4]));
    }    
    static int rowNumber(String s){
        for(int i = 0; i< 3; i++){
        if(c[i].contains(s)) return i;
        }
        return 3;
    }