import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Challenge7
{
    public static void main(String[] args)
    {
        f(
            "1:0|1:1" + "\n" +
            "3:2|5:0" + "\n" +
            "1:1|2:2",
            6
        );

        System.out.println("*************");

        f(
            "4:2|1:5|2:0" + "\n" +
            "1:1|2:0" + "\n" +
            "2:0" + "\n" +
            "1:0" + "\n" +
            "1:5|3:6|1:0" + "\n" +
            "1:1|1:3|2:5",
            11);

        System.out.println("*************");

//        f(
//            "2:1|3:2" + "\n" +
//            "1:0|1:1" + "\n" +
//            "3:2|5:0" + "\n" +
//            "1:1|2:2",
//            10);
//
//        System.out.println("*************");
//
//        f(
//            "2:2|1:5" + "\n" +
//            "3:8|1:0" + "\n" +
//            "4:2|1:5|2:0" + "\n" +
//            "1:1|2:0|4:2" + "\n" +
//            "2:0|2:7" + "\n" +
//            "1:0|1:8" + "\n" +
//            "1:5|3:6|1:0" + "\n" +
//            "1:1|1:3|2:5",
//            9);
    }

    static void f(String s, int c)
    {
        class W
        {
            int n, f, t;
            W(int a, int b, int c) {n=a;f =b;t=c;}

            @Override
            public String toString()
            {
                return n+"@"+f+"->"+ t;
            }
        }

        List<W> w = new CopyOnWriteArrayList<>();
        int floor_count = s.split("\n").length-1;
        for (String f : s.split("\n"))
        {
            for (String v : f.split("\\|"))
            {
                String[] x = v.split(":");
                if(floor_count == Integer.valueOf(x[1])) continue;
                w.add(new W(Integer.valueOf(x[0]), floor_count, Integer.valueOf(x[1])));
            }
            floor_count--;
        }
        floor_count = s.split("\n").length-1;

        System.out.println(w);

        final int[] current_floor = {0};
        final int[] direction = {1};
        final int[] size = {1};
        final int[] stops = {0};
        int prev_w_size = w.size();

        while(true)
        {
            System.out.println(w);

            System.out.println("OUT : " + Arrays.toString(w.stream().filter(v -> v.t == current_floor[0] && Math.signum(v.t - v.f) == direction[0]).toArray())+ " S : " + size[0] + " F : " + current_floor[0] + " D " + direction[0]);

            w.stream().filter(v -> v.t == current_floor[0] && Math.signum(v.t - v.f) == direction[0]).forEach(v -> {size[0] -= v.n;w.remove(v);}); // out

            if(w.size() < prev_w_size) {stops[0]++; prev_w_size = w.size();}

            if(current_floor[0] == floor_count) direction[0]*=-1;

            w.stream().filter(v -> v.f == current_floor[0] && Math.signum(v.t - v.f) == direction[0]).forEach(v -> size[0] += v.n); // in

            System.out.println("IN : " + Arrays.toString(w.stream().filter(v -> v.f == current_floor[0]).toArray()) + " S : "+ size[0] + " F : " + current_floor[0] + " D " + direction[0]);

            if(size[0]>c) { System.out.println("polite after "+stops[0]+" stops at "+current_floor[0]+" floor"); break; }

            if(size[0]==1) { System.out.println("lonely after "+stops[0]+" stops at "+current_floor[0]+" floor"); break; }

            current_floor[0] += direction[0];
        }
    }
}
