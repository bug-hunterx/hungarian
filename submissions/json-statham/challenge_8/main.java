static void f(String s,int c,int w){int i,j,diff,size,inc;List<String>l=new ArrayList<String>();for(i=0;i<s.length();i+=w){l.add(s.substring(i,Math.min(s.length(),i+w)));}
diff=w*l.size()-s.length();for(i=0;i<diff;i++){l.set(l.size()-1,l.get(l.size()-1)+" ");}
size=new Double(Math.ceil(l.size()/(double)c)).intValue();String[][]array=new String[c][size];inc=0;for(i=0;i<array.length;i+=1){for(j=0;j<array[i].length;j+=1){if(inc<l.size()){array[i][j]=l.get(inc);}else{StringBuilder sb=new StringBuilder();for(int a=0;a<w;a++)sb.append(" ");array[i][j]=sb.toString();}
inc++;}}
String[][]tm=tk(array);for(i=0;i<tm.length;i+=1){for(j=0;j<tm[i].length;j+=1){System.out.print(tm[i][j]);if(j+1!=tm[i].length){System.out.print("|");}}
System.out.println();}}
static String[][]tk(String[][]m){String[][]t=new String[m[0].length][m.length];for(int i=0;i<m.length;i++)
for(int j=0;j<m[0].length;j++)
t[j][i]=m[i][j];return t;}