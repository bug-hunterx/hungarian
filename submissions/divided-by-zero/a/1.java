static void f(String s){Character[]a=new Character[s.length()];for(int i=0;i<s.length();i++){a[i]=s.charAt(i);}
Arrays.sort(a,(b,c)->{if(s(s,b)!=s(s,c))
return s(s,b)-s(s,c);return(int)b-(int)c;});String r="";for(char u:a){r+=u;}
System.out.println(r);}
static int s(String s,Object c){int count=0;for(int i=0;i<s.length();++i){if(((char)c)==s.charAt(i)){++count;}}
return count;}