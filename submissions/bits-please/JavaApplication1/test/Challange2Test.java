import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class Challange2Test {
    
    @Test()
    public void Challange2Test1() {
        String r = Main.ch2("FJAFJKLDSKF7JKFDJ");
        assertEquals(r, "7");
    }

    @Test()
    public void Challange2Test2() {
        String r = Main.ch2("ASDFDSASDFDSAzxcPOIUY");
        assertEquals(r, "zxc");
    }

    @Test()
    public void Challange2Test3() {
        String r = Main.ch2("qwERfgHJ123456789");
        assertEquals(r, "qwER");
    }

    @Test()
    public void Challange2Test4() {
        String r = Main.ch2("FGhjKL:\"';lkqwerzxcc");
        assertEquals(r, "zxc");
    }
    
    @Test()
    public void Challange2Test5() {
        String r = Main.ch2("ASDFASDFqwer432!");
        assertEquals(r, "234!");
    }

    @Test()
    public void Challange2Test6() {
        String r = Main.ch2("EUIyouiepIEjhadSDJ(*Y9y9");
        assertEquals(r, "9*(");
    }

    @Test()
    public void Challange2Test7() {
        String r = Main.ch2("1233AERSdfqw");
        assertEquals(r, "123");
    }

    @Test()
    public void Challange2Test8() {
        String r = Main.ch2("ASDF11!*&+1");
        assertEquals(r, "ASDF");
    }
    @Test()
    public void Challange2Test9() {
        String r = Main.ch2("}*3%&2098@$2k234#@$M`");
        assertEquals(r, "}");
    }

    @Test()
    public void Challange2Test10() {
        String r = Main.ch2("wqfdSREA3321");
        assertEquals(r, "123");
    }

    @Test()
    public void Challange2Tes11() {
        String r = Main.ch2(":X:D:):DDDDDDDxDDDD:(;);];]`");
        assertEquals(r, "]");
    }


}
