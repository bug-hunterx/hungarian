static void f(String s){String f="`1234567890-=~!@#$%^&*()_+";String o="qwertyuiop[]QWERTYUIOP{}";String t="asdfghjkl;'\\ASDFGHJKL:\"|";String w="zxcvbnm,./|ZXCVBNM<>?";int[]n={0,0,0,0};Set<Character>p=new HashSet<>();Set<Character>u=new HashSet<>();Set<Character>b=new HashSet<>();Set<Character>v=new HashSet<>();Set[]array={p,u,b,v};for(Character c:s.toCharArray()){if(f.contains(c+"")){p.add(c);n[0]++;}
if(o.contains(c+"")){u.add(c);n[1]++;}
if(t.contains(c+"")){b.add(c);n[2]++;}
if(w.contains(c+"")){v.add(c);n[3]++;}}
int x=0;for(int i=1;i<4;i++){if(n[x]==0)
x=i;else if(n[i]<n[x]&&n[i]!=0)
x=i;if(n[x]==n[i])
if(array[i].size()<array[x].size())
x=i;}
StringBuilder h=new StringBuilder();for(Character c:(Set<Character>)array[x]){h.append(c);}
String e=""+h;int l[]=new int[e.length()];String a="";for(int i=0;i<h.length();i++){Character c=e.charAt(i);int y=f.indexOf(c);if(f.contains(""+c)){y=f.indexOf(c);a=f;}
if(o.contains(""+c)){y=o.indexOf(c);a=o;}
if(t.contains(""+c)){y=t.indexOf(c);a=t;}
if(w.contains(""+c)){y=w.indexOf(c);a=w;}
l[i]=y;}
for(int i=l.length-1;i>0;i--)
for(int j=0;j<i;j++)
if(l[j]>l[j+1]){int tmp=l[j];l[j]=l[j+1];l[j+1]=tmp;}
StringBuilder r=new StringBuilder();for(int i=0;i<l.length;i++)
r.append(a.charAt(l[i]));System.out.println(""+r);}