static String f(String s){
        char[] c=s.trim().toCharArray();
        int a=c.length;
        for(int i=0;i<a;i++){
            if(c[i]=='/')c[i]=tiltRight(c,i+1);
            if(c[i]=='\\')c[i]=tiltLeft(c,i-1);
        }
        String res=(c[0]=='_'&&a!=1&&c[1]!='_'?"_":"")+String.copyValueOf(c)+(c[a-1]=='_'&&a!=1&&c[a-2]!='_'?"_":"");
        res=res.equals("_")?"__":res;
        System.out.print(res);
        return res;
    }

    static char tiltRight(char[] c,int p){
        if(p==c.length){
            return '_';
        }
        if(c[p]==' '){
            c[p]='_';return'_';
        }
        if(c[p]=='\\') {
            return c[p-1];
        }
        if(c[p]=='_') return '/';
        c[p]=tiltRight(c,p+1);
        return c[p]=='|'?c[p-1]:'/';
    }

    static char tiltLeft(char[] c,int p){
        if(p==-1){
            return '_';
        }
        if(c[p]==' '){
            c[p]='_';
            return'_';
        }
        if(c[p]=='/') return c[p+1];
        if(c[p]=='_') return '\\';
        c[p]=tiltLeft(c,p-1);
        return c[p]=='|'?c[p+1]:'\\';
    }