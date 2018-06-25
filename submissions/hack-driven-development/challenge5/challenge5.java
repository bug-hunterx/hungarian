    static void f(String s) {
        String after=" "+s+" ", before="";
        while (!after.equals(before)) {
            before = after;
            StringBuilder sb = new StringBuilder(before);
            for (int i = 0; i < before.length(); i++) {
                char ch = before.charAt(i), right, left;
                if (ch == '/' && before.charAt(i + 1)==' ') {
                        sb.replace(i, i + 2, "__");
                }else if (ch == '\\' && sb.charAt(i - 1) == ' ' ) {
                        sb.replace(i-1, i + 1, "__");
                }else if (ch == '|'){
                    if (before.charAt(i-1)=='/' && before.charAt(i+1)!='\\'){
                        sb.replace(i, i+1, "/");
                    }else if(before.charAt(i+1)=='\\' && before.charAt(i-1)!='/'){
                        sb.replace(i, i+1, "\\");
                    }
                }
            }
            after = sb.toString();
        }
        System.out.println(after.trim());
    }
