
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ch2("ASDFASDFqwer432!"));
    }

static String ch2(String d){List<C>a=new ArrayList<>();for(K b:K.values()){a.add(new C(b));}
for(char c:d.toCharArray()){a.stream().filter((e)->(e.k.contains(c))).map((e)->{String f=e.s;if(!f.contains(String.valueOf(c))){e.s=f+c;}
return e;}).forEach((e)->{e.l+=1;});}
Collections.sort(a);for(Iterator<C>g=a.iterator();g.hasNext();){C next=g.next();if(next.s.isEmpty()){g.remove();}}
String h=a.get(0).s;return o(h);}

static String o(String u){StringBuilder a=new StringBuilder();for(K k:K.values()){a.append(k.c);}
String t=a.toString();List<Character>c=new ArrayList<>();for(Character d:u.toCharArray()){c.add(d);}
Collections.sort(c,(Character x,Character y)->t.indexOf(x)-t.indexOf(y));StringBuilder b=new StringBuilder(c.size());c.stream().forEach((e)->{b.append(e);});return b.toString();}

static class C implements Comparable<C>{K k;String s="";int l=0;C(K keyBoardRow){this.k=keyBoardRow;}@Override
public int compareTo(C other){int lengthDiff=l-other.l;if(lengthDiff!=0){return lengthDiff;}
int stringDiff=s.length()-other.s.length();if(stringDiff!=0){return stringDiff;}
return k.i-other.k.i;}}

static enum K{N(0,"`1234567890-=~!@#$%^&*()_+"),Q(1,"qwertyuiop[]\\QWERTYUIOP{}|"),A(2,"asdfghjkl;'\\ASDFGHJKL:\""),Z(3,"zxcvbnm,./ZXCVBNM<>?");int i;String c;K(int i,String c){this.i=i;this.c=c;}
boolean contains(char s){return c.contains(String.valueOf(s));}}

}
