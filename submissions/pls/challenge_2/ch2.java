static void f(String s) {
String[] a = {"`1234567890-=~!@#$%^&*()_+","qwertyuiop[]QWERTYUIOP{}","asdfghjkl;'\\ASDFGHJKL:\"|","\\zxcvbnm,./|ZXCVBNM<>?"};
String[] x = {"","","",""};
int i;
for(i=0;i<4;++i)
for (char k:s.toCharArray())
x[i]+=a[i].contains(k+"")?k:"";
int ri=0;

for(i=0;i<4;++i)
x[i]=r(x[i]);
for(int k=1;k<4;++k)
ri=x[ri].equals("")||x[ri].length()>x[k].length()&& x[k].length()!=0?k:ri;
for (char e:a[ri].toCharArray())
System.out.print(s.contains(e+"")?e:"");
}

static String r(String s) {
String ss = "";
for (char c:s.toCharArray())
if (!ss.contains(c+""))
ss+=c;
return ss;
}

