public class challenge_2 {

    public static void main(String[] args) {

        String _1 = "FJAFJKLDSKF7JKFDJ";
        String _2 = "ASDFDSASDFDSAzxcPOIUY";
        String _3 = "qwERfgHJ123456789";
        String _4 = "FGhjKL:\"';lkqwerzxcc`";
        String _5 = "ASDFASDFqwer432!";
        String _6 = "EUIyouiepIEjhadSDJ(*Y9y9";
        String _7 = "1233AERSdfqw";
        String _8 = "ASDF11!*&+1";
        String _9 = "}*3%&2098@$2k234#@$M";
        String _10 = "wqfdSREA3321";
        String _11 = ":X:D:):DDDDDDDxDDDD:(;);];]`";

        f(_1);
    }

    static void f(String s) {
        String[] a = {"`1234567890-=¬!\"£$%^&*()_+","qwertyuiop[]QWERTYUIOP{}","asdfghjkl;'#ASDFGHJKL:@~","\\zxcvbnm,./|ZXCVBNM<>?"};
        int[] x = {0,0,0,0};

        for (int i=0; i<4; ++i)
            for (char c : s.toCharArray())
                x[i] += a[i].contains(c + "") ? 1 : 0;

        int result_index = 0;

        for (int k=1; k<4;++k){
            result_index = x[result_index]==0 || x[result_index]>x[k]&& x[k]!=0 ? k : result_index;
        }
        for (char e : a[result_index].toCharArray())
            System.out.print( s.contains(e+"")? e :"");

        System.out.println();
        System.out.println("A:" + x[0]);
        System.out.println("B:" + x[1]);
        System.out.println("C:" + x[2]);
        System.out.println("D:" + x[3]);
    }
}
