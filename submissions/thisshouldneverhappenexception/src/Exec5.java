import static org.junit.Assert.assertEquals;

public class Exec5 {

    public static void main(String[] args) {
         assertEquals("///|\\\\\\", domino("///|\\\\\\"));
         assertEquals("|__\\", domino("| \\\\"));
         assertEquals("/__|", domino("// |"));
         assertEquals("|__\\|__\\|__\\|__\\|", domino("|/ \\|/ \\|/ \\|/ \\|"));
         assertEquals("////__", domino("/||||"));
         assertEquals("/__/__", domino("/| /|")); 
         assertEquals("__\\", domino("|\\")); 
         assertEquals("/__", domino("/|"));
         assertEquals("__\\", domino("\\\\")); 
    }

    static void f(String s) {
        System.out.println(domino(s));
    }

    static String domino(String d) {
        char[] a = d.toCharArray();
        for(char c: a){
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '/') {
                if (rightFree(a, i)) {
                        a[i] = '_';
                        a[i + 1] = '_';
                }
                if (rightStand(a,i+1)) {
                    a[i+1] = '/';
            }  
            }
            if (a[i] == '\\'){
                if (leftFree(a,i) ){
                    a[i] = '_';
                    a[i - 1] = '_';
                }
                if(leftStand(a, i-1)){
                    a[i-1] = '\\';
                }
                }
        }
        }
        
        
        if(a[0] == '\\') {
            a[0] = '_';
            return '_' + String.valueOf(a);
            }
        if(a[a.length-1] == '/'){ 
            a[a.length-1] = '_';
            return String.valueOf(a)+"_";}
        return String.valueOf(a);
    }
    
    static boolean rightFree(char[] d, int p) {
       if(p > d.length - 2)
           return false;
       if(d.length-1 == p || d[p+1] == ' ' )
                return true;
        return false;
    }
    
    static boolean leftFree(char[] d, int p) {
        if(p < 1)
            return false;
        if(0 == p || d[p-1] == ' ' )
                 return true;
         return false;
     }
    
    static boolean leftStand(char[] d, int p){
        if(p < 0)
            return false;
        if(d[p] == '|')
            if(p == 0 || !(d[p-1] == '/') )
                return true;
        return false;
    }
    
    static boolean rightStand(char[] d, int p){
        if(p > d.length - 1)
            return false;
        if(d[p] == '|')
            if(p == d.length-1 || !(d[p+1] == '\\') )
                return true;
        return false;
    }
 
    


}
