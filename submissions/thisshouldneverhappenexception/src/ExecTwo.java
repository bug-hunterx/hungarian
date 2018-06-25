import static org.junit.Assert.assertEquals;


public class ExecTwo {

    public static void main(String[] args) {
        assertEquals("7", f("FJAFJKLDSKF7JKFDJ"));        
        assertEquals("zxc", f("ASDFDSASDFDSAzxcPOIUY"));
        assertEquals("qwER", f("qwERfgHJ123456789"));
        assertEquals("zxc",f("FGhjKL:\"';lkqwerzxcc"));   
        assertEquals("234!",f("ASDFASDFqwer432!"));
        assertEquals("9*(", f("EUIyouiepIEjhadSDJ(*Y9y9"));
        assertEquals("123", f("1233AERSdfqw"));
        assertEquals("ASDF", f("ASDF11!*&+1"));
        assertEquals("123", f("wqfdSREA3321"));
        assertEquals("}", f("}*3%&2098@$2k234#@$M"));
        assertEquals("]", f(":X:D:):DDDDDDDxDDDD:(;);];]"));
    }

    static String[] c = new String[]{"`1234567890-=~!@#$%^&*()_+","qwertyuiop[]\\QWERTYUIOP{}|","asdfghjkl;'ASDFGHJKL:\"","zxcvbnm,./ZXCVBNM<>?"};

    
    static String f(String s){        
        String[] r = new String[]{"","","","",""};
        int[] d = new int[]{0,0,0,0};
        int leastRow = 0;
        for(int i = 0; i<s.length(); i++){
           String subString = s.substring(i,i+1); 
           int n = rowNumber(subString);
           if(r[n].contains(subString)){
               d[n]++;
           }
           else{
               r[n]+=subString;
           }
           leastRow = n;
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
        return String.valueOf(r[4]);
    }
    
    static int rowNumber(String s){
        for(int i = 0; i< 3; i++){
        if(c[i].contains(s)) return i;
        }
        return 3;
    }
}
