void f(int c){int n=c;
#define R(a)n=(((n+a-1)/a)*a)
if(n<2000)R(100);else if(n<5000)R(500);else{n=n+n/10;n=n-(n%500)+((n%500>250)?500:0);}n-=c;printf((!n||n>1500)?"PAID BY CARD":(n%100)?"KEEP THE CHANGE YOU FILTY ANIMAL":"HERE IS %d",c+n);}