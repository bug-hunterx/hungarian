static void f(String i){System.out.println(i.chars().boxed().map(s->Character.toString((char)s.intValue())).collect(Collectors.groupingBy(ch->r(ch),Collectors.mapping(c->c,Collectors.toList()))).entrySet().stream().sorted((a,b)->{List<String>o=a.getValue(),p=b.getValue();return o.size()==p.size()?u(i,o)==u(i,p)?a.getKey()-b.getKey():u(i,o)-u(i,p):o.size()-p.size();}).findFirst().get().getValue().stream().distinct().sorted((a,b)->c(a,b)).reduce((a,b)->a+b).get());}static int u(String i,List<String>a){return(int)a.stream().filter(s->i.indexOf(s)==i.lastIndexOf(s)).count();}static int c(String a,String b){return k().get(r(a)).indexOf(a)-k().get(r(b)).indexOf(b);}static Integer r(String s){return k().entrySet().stream().filter(e->e.getValue().contains(s)).findFirst().get().getKey();}static Map<Integer,List<String>>k(){Map<Integer,List<String>>k=new HashMap<>();k.put(1,Arrays.asList("`1234567890-=~!@#$%^&*()_+".split("")));k.put(2,Arrays.asList("qwertyuiop[]\\QWERTYUIOP{}|".split("")));k.put(3,Arrays.asList("asdfghjkl;\'ASDFGHJKL:\"".split("")));k.put(4,Arrays.asList("zxcvbnm,./ZXCVBNM<>?".split("")));return k;}