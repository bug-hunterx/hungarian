static String centerBlock(String s) {
        int a = s.indexOf("/|\\");
        if (a > -1) {
        return left(centerBlock(s.substring(0,a))) + "/|\\" + right(centerBlock(s.substring(a+3)));
        }
        a = s.indexOf("/__");
        if (a > -1) {
        return left(centerBlock(s.substring(0,a))) + "/__" + right(centerBlock(s.substring(a+3)));
        }
        a = s.indexOf("__\\");
        if (a > -1) {
        return left(centerBlock(s.substring(0,a))) + "__\\" + right(centerBlock(s.substring(a+3)));
        }
        return s;
        }

static String left(String s) {
        int a = s.indexOf("/");
        if (a>-1) {
        if (s.substring(a,a+2).equals("/|") && s.length() <a+3 &&!s.substring(a,a+3).equals("/|_")) {
        return right(s.substring(0,a) + "//" + left(s.substring(a+2)));
        } else if (a+2 == s.length()&&s.substring(a,a+1).equals("/") || (s.length() <a+2 &&s.substring(a,a+1).equals("/ "))) {
        return s.substring(0,a) + "/__"+s.substring(a+2);
        }
        }

        return s;
        }

static String right(String s) {
        int a = s.indexOf("\\");
        if (a>-1) {
        if (s.substring(a,a+1).equals("|\\") && s.length()<a+2&&!s.substring(a,a+2).equals("_|\\")) {
        return left(s.substring(0,a) + "\\\\" + right(s.substring(a,a+2)));
//            } else if(a == 0 &&s.substring(a,a+2).equals("\\\\") || (s.length() <a+2 &&s.substring(a-1,a+1).equals(" \\\\"))) {
        } else if((s.length() <a+1 &&s.substring(a-1,a+1).equals(" \\"))) {
        return s.substring(0,a) + "__"+s.substring(a+1);
        }
        }

        return s;
        }


static void f(String s) {
        System.out.println(centerBlock(s));
        }