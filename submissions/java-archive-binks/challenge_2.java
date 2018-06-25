static void f(String s) {
        String[] rows= {"`1234567890-=~!@#$%^&*()_+","qwertyuiop[]QWERTYUIP{}","asdfghjkl;'\\ASDFGHJKL:\"|","zxcvbnm,./ZXCVBNM<>?"};
        int[] occurences = new int[4];
        int[] uniqueChars = new int[4];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for(int i=0;i<chars.length;i++){
            for(int j=0;j<4;j++){
                if(rows[j].contains(""+chars[i])){
                    occurences[j]++;
                    if(i==0 || chars[i]!=chars[i-1]){
                        uniqueChars[j]++;
                    }
                }
            }
        }
        int row = -1;
        for(int i=0;i<4;i++) {
            if(occurences[i]>0 && (row == -1 || (occurences[i] < occurences[row]) || (occurences[i] == occurences[row] && uniqueChars[i] < uniqueChars[row]))){
              row = i;
            }
        }
        for(char c: rows[row].toCharArray()){
            if(s.contains(""+c)){
                System.out.print(c);
            }
        }
    }