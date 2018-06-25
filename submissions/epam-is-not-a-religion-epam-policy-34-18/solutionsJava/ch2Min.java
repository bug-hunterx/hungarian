public static void  f(String i) {
        Map<Integer, String> map = new HashMap<>();
        List<String> rowList = new ArrayList<>();
        rowList.add("`1234567890-=\\~!@#$%^&*()_+|");
        rowList.add("qwertyuiop[]QWERTYUIOP{}");
        rowList.add("asdfghjkl;'ASDFGHJKL:\"" );
        rowList.add("zxcvbnm,./ZXCVBNM<>?");
        int[] lengths={0,0,0,0};

        for (int index = 0 ; index < i.length() ; index++ ) {
        String actualChar = String.valueOf(i.charAt(index));
        for(int ri = 0 ; ri < rowList.size() ; ri++) {
        if(rowList.get(ri).contains(actualChar)) {
        if (map.get(ri) != null) {
        if (!map.get(ri).contains(actualChar)) {
        int charIndex = rowList.get(ri).indexOf(actualChar);
        boolean successInsert = false;
        for (int si = 0 ; si < map.get(ri).length() ; si++) {
        String s = map.get(ri);
        int mapCharIndex = rowList.get(ri).indexOf(String.valueOf(s.charAt(si)));
        if (charIndex < mapCharIndex) {
        map.put(ri, s.substring(0, si) + actualChar + s.substring(si));
        successInsert = true;
        break;
        }
        }
        if (!successInsert) map.put(ri, map.get(ri) + actualChar);
        }
        } else {
        map.put(ri, actualChar);
        }
        lengths[ri] = ++lengths[ri];
        }
        }
        }

        System.out.print(
        map.entrySet().stream().sorted((o1, o2) -> {
        int c = 0;
        if(lengths[o1.getKey()] != lengths[o2.getKey()]) {
        c = lengths[o1.getKey()] < lengths[o2.getKey()] ? -1 : +1;
        } else if(lengths[o1.getKey()] == lengths[o2.getKey()]) {
        if(o1.getValue().length() == o2.getValue().length()) {
        c = o1.getKey() < o2.getKey() ? -1 : 1;
        } else {
        c = o1.getValue().length() < o2.getValue().length() ? -1 : +1;
        }
        }
        return c;
        }).findFirst().get().getValue()
        );
        }