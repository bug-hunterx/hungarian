import java.util.Arrays;

public class C5Runnable {

    static String f(String s){
        s=" "+s+" ";
        char[]d=s.toCharArray();
        int l=d.length;
        for(int i=0; i<l; i++){
            if(r(d[i])&&e(d[i+1])){
                d[i]='_';
                d[i+1]='_';
            } else if(l(d[i])&&e(d[i-1])){
                d[i]='_';
                d[i-1]='_';
            }
        }
        char[]r=Arrays.copyOf(d, l);
        for(int j=0; j<l; j++){
            d=Arrays.copyOf(r, l);
            for(int i=0; i<l; i++){
                e(d, r, i);
            }
        }
        System.out.print(new String(r));
        return String.valueOf(r).trim();
    }

    static void e(char[]d, char[]r, int i){
        if(!e(d[i])&&d[i]!= '_'){
            if(!r(d[i-1])|| !l(d[i+1])){
                if(r(d[i-1])&&d[i]!='\\'){
                    if(e(d[i+1])){
                        r[i]='_';
                        r[i+1]='_';
                    } else {
                        r[i]='/';
                    }
                }
                if(l(d[i+1])&&d[i]!='/'){
                    if(e(d[i-1])){
                        r[i]='_';
                        r[i-1]='_';
                    } else {
                        r[i]='\\';
                    }
                }
            }
        }

    }

    static boolean e(char d){
        return d==' ';
    }

    static boolean r(char d){
        return d=='/';
    }

    static boolean l(char d){
        return d=='\\';
    }

}