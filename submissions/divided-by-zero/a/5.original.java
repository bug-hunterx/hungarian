import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class five2 {

    public static void main(String[] args) {
        f("//__|__\\\\");
    }

    static void f(String s) {

        StringBuilder sb = new StringBuilder(" " + s + " ");

        List<Change> changes = new ArrayList<>();

        for (int i = 0; i < sb.length(); ++i) {

            char domino = sb.charAt(i);

            if (domino == '/' && sb.charAt(i + 1) == '|') {

                changes.add(new Change(i + 1, '/'));

            } else if (domino == '\\' && sb.charAt(i - 1) == '|') {

                changes.add(new Change(i - 1, '\\'));

            } else if (domino == '/' && sb.charAt(i + 1) == ' ') {

                Change c = new Change(i + 1, '_');
                c.dependency = new Change(i, '_');
                changes.add(c);

            } else if (domino == '\\' && sb.charAt(i - 1) == ' ') {
                Change c = new Change(i - 1, '_');
                c.dependency = new Change(i, '_');
                changes.add(c);
            }
        }

        if( changes.size() == 0 ) {
            System.out.println(sb.toString().trim());
        } else {
            int z = a(changes, sb);
            if( z > 0 )
                f(sb.toString().trim());
            else
                System.out.println(sb.toString().trim());
        }
    }

    static int a(List<Change> changes, StringBuilder sb) {

        int changesApplyed = 0;

        while (changes.size() > 0) {
            Change remove = changes.remove(0);
            if (remove.dependency != null) {
                sb.setCharAt(remove.pos, remove.c);
                Change dep = remove.dependency;
                sb.setCharAt(dep.pos, dep.c);
                changesApplyed++;
            } else if( !changes.contains(remove) ) {
                sb.setCharAt(remove.pos, remove.c);
                changesApplyed++;
            }
            while(changes.remove(remove));
        }
        return changesApplyed;
    }

    static class Change {
        int pos;
        char c;
        Change dependency;

        public Change(int pos, char c) {
            this.c = c;
            this.pos = pos;
        }

        @Override
        public boolean equals(Object o) {
            Change change = (Change) o;
            return pos == change.pos;
        }
    }
}