static void f(String str){
class F2c{
    int f2c(String str, String r, boolean chck){
        int count = 0;
        String f="";
        Matcher matcher = Pattern.compile(r).matcher(str);

        while (matcher.find()) {
            String g = matcher.group();
            if (chck){if(!f.contains(g)){f+=g;
                count++;}}else{count++;}
        }
        return count;
    }
}
    String[] reg = {
            "[1234567890-=!@#$%^&*()_+]",
            "[qwertyuiop\\[\\]QWERTYUIOP{}\\\\/|]",
            "[asdfghjkl;'ASDFGHJKL:\"]",
            "[zxcvbnm,.ZXCVBNM<>?]"
    };
    F2c t = new F2c();
    int s=0;
    int y=0;
for (int i=0;i<4;i++){
        int a=t.f2c(str,reg[i],true);
        if(a>=y){s=i;y=a;}
        }

        String st="";
        for(char c:str.toCharArray()){
        if (!reg[s].substring(1,reg[s].length()-1).contains(c+""))
        st+=c;
        }
        y=1000;
        for (int i=0;i<4;i++){
        int a=t.f2c(st,reg[i],true);
        if(a<y&&a!=0){y=a;s=i;}
        }

        for (char c:reg[s].substring(1,reg[s].length()-1).toCharArray()){
        if(st.contains(c+""))
        System.out.print(c);
        }
        }