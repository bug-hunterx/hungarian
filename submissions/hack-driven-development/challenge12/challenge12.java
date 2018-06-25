    static void f(String s, int width, int height){
        String[] a = s.split("\n");
        char[][] court = new char[a.length+height*2][a[0].length()+width*2];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length();j++){
                court[i+height][j+width]=a[i].charAt(j);
            }
        }
        String hor ="<>";
        String ver ="^v";
        String both=hor+ver;
        char f='^', l='v', j='>', b='<', d=j, i;
        List<String> p = new ArrayList<>();
        int x=height, y=width,tmp, m,n;
        boolean W=true, H=true;
        Map<Character, Integer> c;
        p.add(x+","+y+d);

        while(true) {
            c = new HashMap<>();
            for(m=0;m<height;m++){
                for(n=0;n<width;n++){

                    i = court[m+x][n+y];
                    tmp = c.getOrDefault(i,0);
                    c.put(i, tmp+1);
                }
            }
            W = c.getOrDefault('w',0)<=c.getOrDefault('W',0);
            H = c.getOrDefault('h',0)<=c.getOrDefault('H',0);
            String lookfor;
            if (H && W){
                lookfor = both;
            }else if (H){
                lookfor = hor;
            }else{
                lookfor = ver;
            }

            if(c.entrySet().stream().filter(q->lookfor.contains(q.getKey().toString())).count()==0){
                System.out.println(9);
                break;
            }
            int max = c.entrySet().stream().filter(q->lookfor.contains(q.getKey().toString())).max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
            long count = c.entrySet().stream().filter(q->q.getValue()==max && lookfor.contains(q.getKey().toString())).count();
            if(count == 1) {
                d=c.entrySet().stream().filter(q->q.getValue()==max && lookfor.contains(q.getKey().toString())).findFirst().get().getKey();
            }
            if (d==f){
                x--;if(x<0){x=0;}
            }
            if (d==l){
                x++;if(x>=court.length-height){x=court.length-height;}
            }
            if (d==j){
                y++;if(y>=court[0].length-width){y=court[0].length-width;}
            }
            if (d==b){
                y--;if(y<0){y=0;}
            }
            String movement = x+","+y+d;
            if(p.contains(movement)) {
                System.out.println(8);
                break;
            }
            p.add(movement);

        }
    }