public static void f(String g){String w="";int[]l={147,258,369,123,456,789,159,357};for(int i=0;i<l.length;i++){w+=".*["+l[i]+"].*["+l[i]+"].*["+l[i]+"].*";w+=l.length-1>i?"|":"";}
String o="",x="";for(int i=0;i<g.length();i++){if(i%2==0){o+=g.charAt(i);}else{x+=g.charAt(i);}
if(o.matches(w)){System.out.println("O");return;}else if(x.matches(w)){System.out.println("X");return;}}
System.out.println("?");}