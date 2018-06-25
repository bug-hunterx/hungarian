static void f(String s,int n,int w){
        int rs = (s.length()-1)/(n*w)+1;
        int i=0;
        while(i<(w+1)*n*rs){
            if(i%(w+1)==w){
                System.out.print((i+1)/(w+1)%n==0?"\n":"|");
            }else{
                int p = i%(w+1);
                int c = (i/(w+1))%n;
                int r = i/((w+1)*n);
                int j=c*w*rs+w*r+p;
                System.out.print(j<s.length()?s.charAt(j):" ");
            }
            i++;
        }
    }