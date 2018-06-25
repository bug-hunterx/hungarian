static void f(String a){
char[] b=(" "+a+" ").toCharArray();
boolean c=true,r=false,l=false,n=false;
while(c){
c=false;
for(int i=0;i<b.length;i++){
if(b[i]=='/')
if(b[i+1]==' '){
b[i]='_';
b[i+1]='_';
c=true;
r=false;
i++;
}else r=true;
if(b[i]=='_')r=false;
if(b[i]=='|'){
if(r&&b[i+1]!='\\'){
b[i]='/';
c=true;
n=true;
}
r=false;
}
}
for(int i=b.length-1;i>0;i--){
if(b[i]=='\\'){
if(b[i-1]==' '){
b[i]='_';
b[i-1]='_';
c=true;
l=false;
i--;
}else l=true;
}
if(b[i]=='_')l=false;
if(b[i]=='|'){
if(l&&b[i-1]!='/'||(l&&n)){
b[i]='\\';
c=true;
}
l=false;
}
}
n=false;
}
System.out.println(b);
}
