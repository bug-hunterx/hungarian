class challenge1 {
    public static void main(){
        f("Results, Relentlessly");
    }

    static void f(String s) {
        Stream.of(s).map(w -> w.split("")).flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted((c1, c2) -> {
                    int v = c1.getValue().compareTo(c2.getValue());
                    return v == 0 ? c1.getKey().compareTo(c2.getKey()) : v;
                }).forEach(c -> {
            for (int i = 0; i < c.getValue(); i++) {
                System.out.print(c.getKey());
            }
        });
    }
}