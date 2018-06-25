public static void f(String i){boolean end=false;char[]m=i.toCharArray();for(int j=5;j<=m.length;j++){int[]t=new int[9];for(int k=0;k<j;k++){t[Integer.parseInt(m[k]+"")-1]=k%2+1;}
for(int l=1;l<14;l+=7){if(c(t,0,1,2,l)||c(t,3,4,5,l)||c(t,6,7,8,l)||c(t,0,3,6,l)||c(t,1,4,7,l)||c(t,2,5,8,l)||c(t,0,4,8,l)||c(t,2,4,6,l))
{System.out.println(l==1?"O":"X");end=true;break;}}
if(end)
break;}
if(!end)
System.out.println("?");}
public static boolean c(int[]m,int f,int s,int t,int p){return(m[f]%3)*(m[s]%3)*(m[t]%3)==p;}