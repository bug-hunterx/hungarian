static void f(String s){StringBuilder x=new StringBuilder(" "+s+" ");List<T>w=new ArrayList<>();for(int i=0;i<x.length();++i){char q=x.charAt(i);if(q=='/'&&x.charAt(i+1)=='|'){w.add(new T(i+1,'/'));}else if(q=='\\'&&x.charAt(i-1)=='|'){w.add(new T(i-1,'\\'));}else if(q=='/'&&x.charAt(i+1)==' '){T c=new T(i+1,'_');c.d=new T(i,'_');w.add(c);}else if(q=='\\'&&x.charAt(i-1)==' '){T c=new T(i-1,'_');c.d=new T(i,'_');w.add(c);}}
if(w.size()==0){System.out.println(x.toString().trim());}else{int z=a(w,x);if(z>0)
f(x.toString().trim());else
System.out.println(x.toString().trim());}}
static int a(List<T>m,StringBuilder b){int v=0;while(m.size()>0){T k=m.remove(0);if(k.d!=null){b.setCharAt(k.p,k.c);T dep=k.d;b.setCharAt(dep.p,dep.c);v++;}else if(!m.contains(k)){b.setCharAt(k.p,k.c);v++;}
while(m.remove(k));}
return v;}
static class T{int p;char c;T d;public T(int p,char c){this.c=c;this.p=p;}@Override
public boolean equals(Object o){T t=(T)o;return p==t.p;}}