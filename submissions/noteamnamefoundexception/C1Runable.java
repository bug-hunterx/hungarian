public class C1Runable {

    public static void main(String[] args) {
        f("Hello, World!");
        f("Results, Relentlessly");
    }

static void f(String a){
int s=256;
int[][] f=new int[s][1];
a.chars().forEach(c->f[c][0]++);
int[][] r=new int[s][s];
for(int i=0;i<s;i++){
int fr=f[i][0];
if (fr==0)continue;
r[fr][i]=1;
}
for(int i=0;i<s;i++){
int t[]=r[i];
for (int k=0;k<s;k++){
int h=t[k];
if(h==1)for(int z=0;z<i;z++)System.out.print((char)k);
}
}
}
}
