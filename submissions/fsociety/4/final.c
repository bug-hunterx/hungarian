void f(char*s){int b[9]={0},p=1,w=0;while(*s){b[*s++-49]=(p^=1)+1;
#define C(x,y,z)if(!w&&b[x]&&!((b[x]^b[y])|(b[y]^b[z]))){w=b[x];break;};
C(0,1,2)C(3,4,5)C(6,7,8)C(0,3,6)C(1,4,7)C(2,5,8)C(0,4,8)C(2,4,6)}printf("%c",w?w&2?88:79:63);}