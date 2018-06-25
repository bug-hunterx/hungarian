static String step(String s){
        return s.replace("/ ","__").replace("/| ","/( ").replace("/|_","/(_").replace("/|/","/(/").replace("/|)","//)").replace("/||","/(|");
    }
    static String fin(String s){
        return s.replace("(","/").replace(")","\\");
    }

    static String reverse(String s){
        return new StringBuilder(s).reverse().toString().replace("/","a").replace("\\","/").replace("a","\\").replace("(","a").replace(")","(").replace("a",")");
    }
    static String bigStep(String s){
        return fin(reverse(step(reverse(step(s)))));
    }

    static void f(String s){
        s = " " + s + " ";
        while(!s.equals(bigStep(s))){
            s = bigStep(s);
        }
        System.out.print(s);
    }