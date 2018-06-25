void f(int c){int s=(c<2000)?g(c,100):(c<5000)?g(c,500):r(c*1.1/500.0)*500;int t=s-c;printf((t==0||t>1500)?"PAID BY CARD":(t%100!=0)?"KEEP THE CHANGE YOU FILTY ANIMAL":"HERE IS %d",s);}
int g(int c,int r){return c%r==0?c:(c+r)/r*r;}
int r(double x){if(x<0.0)return(int)(x-0.5);else return(int)(x+0.5);}
