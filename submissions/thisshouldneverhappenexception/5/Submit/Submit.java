 static void f(String s) {
        System.out.println(domino(s));
    }

    static String domino(String d) {
        char[] a = d.toCharArray();
        int l = a.length-1;
        for (int i = 0; i <= l; i++) {
            if (a[i] == '/') {
                 if(isTie(a, i+1)){
                    a[i+1]= '/';
                    a[i+2]= '\\';
                }
                if (rightFree(a, i)) {
                        a[i] = '_';
                        a[i + 1] = '_';
                }
                if (rightStand(a,i+1)) {
                    a[i+1] = '/';                    
                }                
            }
            if (a[l-i] == '\\'){
                if (leftFree(a,l-i) ){
                    a[l-i] = '_';
                    a[l-i - 1] = '_';
                }
                if(leftStand(a, l-i-1)){
                    a[l-i-1] = '\\';
                }
                }
        }    
        String s = String.valueOf(a);
        if(s.charAt(l)== '/')
            s=s.substring(0,l)+"__";
        if(s.charAt(0) == '\\') 
           s="__"+s.substring(1);
        return s;
    }
   
     static boolean isTie(char[] d, int p) {
        if(p < d.length-2&&d[p]=='|' && d[p+1]== '|'&& d[p+2]=='\\') return true;
        return false;
    }

    static boolean rightFree(char[] d, int p) {
       if(p<d.length - 1 && d[p+1] == ' ' )
                return true;
        return false;
    }
    
    static boolean leftFree(char[] d, int p) {
        if(p>0 && d[p-1] == ' ' && (p<2 || d[p-2]!='/'))
                 return true;
         return false;
     }
    
    static boolean leftStand(char[] d, int p){
        if(p > -1 && d[p] == '|' )
            if(p == 0 || !(d[p-1] == '/') )
                return true;
        return false;
    }
    
    static boolean rightStand(char[] d, int p){
        if(p < d.length && d[p] == '|')
            if(p == d.length-1 || !(d[p+1] == '\\') )
                return true;
        return false;
    }    
