import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class ExecOne {

    public static void main(String[] args) {
        String s = "Hello, World!";
        f(s);
    }

    public static void f(String s){
        (new TreeMap<>(s.chars().mapToObj(e->(""+(char)e)).collect(Collectors.toMap(w->w,w->1,Integer::sum)))).entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(x->{int l=x.getValue();while(l>0){l--;System.out.print(x.getKey());}});
    }
}
