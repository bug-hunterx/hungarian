void f(char*s){int l=strlen(s);
#define M(n)char n[l+3];strcpy(n+1,s);*n=32;n[l+2]=0;
M(a)M(b)char*i=b+1,*o=a+1,*x;int c,t;do{t=0;x=i;i=o;o=x;for(c=0;c<l;c++){o[c]=i[c];if(i[c]=='|'){if(i[c-1]==47&&i[c+1]!=92){o[c]=47;t++;}else if(i[c+1]==92&&i[c-1]!=47){o[c]=92;t++;}}
#define F(k,u)else if(i[c]==k&&i[c u 1]<=32){o[c]=o[c u 1]=i[c u 1]=95;t++;}
F(92,-)F(47,+)}}while(t);printf("%s",i-1);}