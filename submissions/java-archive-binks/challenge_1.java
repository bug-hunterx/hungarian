static void f(String s) {
        Map<Integer, Long> charCount = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Comparator<Map.Entry<Integer, Long>> cmp = Comparator.comparing(Map.Entry::getValue);
        List<Map.Entry<Integer, Long>> list = charCount.entrySet().stream().sorted(cmp.thenComparing(Map.Entry::getKey)).collect(Collectors.toList());
        String r = "";
        for (Map.Entry<Integer, Long> entry: list) {
            for(int i = 0; i<entry.getValue(); i++) {
                r += Character.toString((char) entry.getKey().intValue());
            }
        }
        System.out.println(r);
    }