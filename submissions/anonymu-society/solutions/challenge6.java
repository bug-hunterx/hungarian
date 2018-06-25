static void f(int c){int t=-1;int r=-1;int d=-1;int p=-1;if(c<2000){r=((c+99)/100)*100;t=r-c;}else if(c<5000){r=(int)(c/500.0+.5)*500;d=(int)(c/1000.0+.5)*1000;if(Math.abs(r-c)>Math.abs(d-c)){t=d-c;r=d;}else{t=d-c;}
if(t<0){r=c+500+t;}
t=r-c;}else{p=(int)((c*100.0f)/1000);int w=(c+p);r=500*Math.round(w/500);d=(int)(w/1000.0+.5)*1000;if(r-w!=0){if(Math.abs(r-w)>Math.abs(d-w)){if((w-c)>1500){t=w-c;}else if(Math.abs(d-w)<80){t=d-r-w;}else if(Math.abs(d-w)<200){t=d-c;}else{t=r-c;}
r=d;}else if(Math.abs(r-w)==Math.abs(d-w)){r=d;t=r-c;}else{t=r-c;}}else{t=r-c;}}
String m="";if(t==0||t>1500){m="PAID BY CARD";}else if(((t%100)!=0&&p!=-1)||t<100){m="KEEP THE CHANGE YOU FILTY ANIMAL";}else{m="HERE IS "+r;}
System.out.print(m);}