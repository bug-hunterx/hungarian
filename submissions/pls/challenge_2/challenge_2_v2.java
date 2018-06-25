public class challenge_2_v2 {

    public static void main(String[] args) {

        String _1 = "FJAFJKLDSKF7JKFDJ";
        String _2 = "ASDFDSASDFDSAzxcPOIUY";
        String _3 = "qwERfgHJ123456789";
        String _4 = "FGhjKL:\"';lkqwerzxcc";
        String _5 = "ASDFASDFqwer432!";
        String _6 = "EUIyouiepIEjhadSDJ(*Y9y9";
        String _7 = "1233AERSdfqw";
        String _8 = "ASDF11!*&+1";
        String _9 = "}*3%&2098@$2k234#@$M";
        String _10 = "wqfdSREA3321";
        String _11 = ":X:D:):DDDDDDDxDDDD:(;);];]";

        f(_4);
    }

    static void f(String s) {
        String[] a = {"`1234567890-=~!@#$%^&*()_+","qwertyuiop[]QWERTYUIOP{}","asdfghjkl;'\\ASDFGHJKL:\"|","\\zxcvbnm,./|ZXCVBNM<>?"};
        String[] x = {"","","",""};
        for (int i=0; i<4; ++i)
            for (char c : s.toCharArray())
                x[i] += a[i].contains(c + "") ? c : "";

        int ri = 0;

        for (int i = 0; i<4;++i)
            x[i]=r(x[i]);

        for (int k=1;k<4;++k)
            ri = x[ri].equals("") || x[ri].length()>x[k].length()&& x[k].length()!=0?k:ri;

        for (char e : a[ri].toCharArray())
            System.out.print(s.contains(e+"")?e:"");
    }

    static String r(String s) {
        String ss = "";
        for (char c : s.toCharArray())
            if (!ss.contains(c+""))
                ss+=c;
        return ss;
    }
}
