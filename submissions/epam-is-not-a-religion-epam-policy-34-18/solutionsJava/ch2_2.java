public static void f(String i) {
        String[] keyboard = new String[] {"\u0003`1234567890-=\\~!@#$%^&*()_+|" , "qwertyuiop[]QWERTYUIOP{}",
        "asdfghjkl;'ASDFGHJKL:\"", "zxcvbnm,./ZXCVBNM<>?"};
        String[] input = new String[]{"","","",""};
        boolean[][] uniqueInput = new boolean[][]{new boolean[keyboard[0].length()], new boolean[keyboard[1].length()], new boolean[keyboard[2].length()], new boolean[keyboard[3].length()]};
        int min = 0;
        for (int index = 0 ; index < i.length() ; index++ ) {
        for (int j = 0 ; j < keyboard.length ; j++ ) {
        if (keyboard[j].indexOf(i.charAt(index)) > -1) {
        input[j] += i.charAt(index);
        if (!uniqueInput[j][keyboard[j].indexOf(i.charAt(index))]) {
        uniqueInput[j][keyboard[j].indexOf(i.charAt(index))] = true;
        }
        min = j;
        break;
        }
        }
        }
        //calculate row unique character numbers
        int[] num = new int[4];
        for (int j = 0; j < uniqueInput.length; j++) {
        for (int k = 0; k < uniqueInput[j].length; k++) {
        if (uniqueInput[j][k]) {
        num[j]++;
        }
        }
        }
        //search the row which have the least unique character
        for (int j = 0; j < input.length; j++) {
        if (num[min] > num[j] && num[j] != 0) {
        min = j;
        }
        }
        // if more than one more has the same unique charahter length, then return the top row
        for (int j = 0; j < uniqueInput.length; j++) {
        if (num[min] == num[j] && j < min) {
        min = j;
        }
        }
        for (int j = 0; j < uniqueInput[min].length; j++) {
        if (uniqueInput[min][j]) {
            System.out.print(keyboard[min].charAt(j));
        }
        }
        }