static void f(String s){String o="";String x="";String w[]={"123","456","789","147","258","369","159","357"};boolean y=true;PrintStream l=System.out;for(char c:s.toCharArray()){if(y) {y=false;o+=c;}else{y=true;x+=c;}for(String a:w){int p=0;int j=0;for(char q:a.toCharArray()){if(x.contains(q+""))p++;if(o.contains(q+""))j++;}if(p==3){l.println("X");return;}if(j==3){l.println("O");return;}}}l.println("?");}