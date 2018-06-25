import org.junit.Assert;

public class Exec6 {

    public static void main(String[] args) {
        Assert.assertEquals(fTest(100), "PAID BY CARD");
        Assert.assertEquals(fTest(15000), "HERE IS 16500");
        Assert.assertEquals(fTest(1199), "KEEP THE CHANGE YOU FILTY ANIMAL");
        Assert.assertEquals(fTest(1999), "KEEP THE CHANGE YOU FILTY ANIMAL");
        Assert.assertEquals(fTest(6185), "KEEP THE CHANGE YOU FILTY ANIMAL");
        Assert.assertEquals(fTest(6288), "KEEP THE CHANGE YOU FILTY ANIMAL");
        Assert.assertEquals(fTest(2800), "HERE IS 3000");
        Assert.assertEquals(fTest(2500), "PAID BY CARD");
        //fTest(5100);
    }

    static String fTest(int cost) {
            int rounded;
            if (cost < 2000) rounded = ((cost+99)/100)*100;
            else if (cost < 5000) rounded = ((cost+499)/500)*500;
            else {
                int tp = ((int)(cost*1.1));
                if (tp%500<250) rounded=tp-(tp%500);
                else rounded=((tp+499)/500)*500;
            }
            int tip = rounded-cost;
            if (tip==0 || tip>1500) return "PAID BY CARD";
            else if (tip%100 != 0) return "KEEP THE CHANGE YOU FILTY ANIMAL";
            else return "HERE IS " + rounded;
    }

    static void f(int c) {
        int r;
        if(c<2000)r=((c+99)/100)*100;else if (c < 5000) r = ((c+499)/500)*500;else{int tp = ((int)(c*1.1));if (tp%500<250) r=tp-(tp%500);else r=((tp+499)/500)*500;}
        if (r-c==0 || r-c>1500) System.out.print("PAID BY CARD");
        else if ((r-c)%100 != 0) System.out.print("KEEP THE CHANGE YOU FILTY ANIMAL");
        else System.out.print("HERE IS "+r);
    }
}
