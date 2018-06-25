static void f(int m,String n){String[]s=n.split("\n");int l=0,w=0,y=0,k=s.length;int[]o=new int[99];for(int x=0;x<s[0].length();x++){String t="";int b=0;for(int i=0;i<k;i++){char c=s[k-i-1].charAt(x);b+=(c=='/'?1:c=='\\'?-1:0);if(b>1||b<-1){b=9;}
t+=c;}
l+=b==0&&t.matches("^[X]+[\\\\/\\|]+(\\$)[^X\\\\/\\.\\$]*$")?1:0;boolean f=b==0&&t.matches("^[X]+[\\\\/\\|]+(\\.)[^X\\\\/\\.\\$]*$");w+=f?1:0;if(f){o[y++]=(k-t.indexOf('.')-1)*(s[0].length()+1)+x;}}
if(l+w==0){System.out.println(":(");}else if(m>l+w){System.out.println(m-l-w);}else if(m<l){System.out.println(m-l);}else{for(int i=0;i<m-l;i++){n=n.substring(0,o[i])+'$'+n.substring(o[i]+1,n.length());}
System.out.println(n);}}