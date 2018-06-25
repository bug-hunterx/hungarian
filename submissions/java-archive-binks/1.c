void f(char* a){int m[255],n,p,i,j;for(n=0;n<255;n++)m[n]=0;for(n=0;a[n];n++){m[a[n]]++;}for(p=0;p<n*n*255;p++){i=p/(255*n);j=(p/n)%255;if(m[j]==i&&p%n<i){printf("%c",j);}}}
