#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
rm negyedik.exe 2>/dev/null; gcc negyedik.c -o negyedik && ./negyedik.exe

 1 | 2 | 3
---+---+---
 4 | 5 | 6
---+---+---
 7 | 8 | 9


 0 | 1 | 2
---+---+---
 3 | 4 | 5
---+---+---
 6 | 7 | 8

The first move is always made by `O`.

E.g. game `5237649` is:
   | X | O
---+---+---
 X | O | O
---+---+---
 X |   | O
0 - 0
1 - X
 */
void f2(char *s) {
	int w[8][3] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},
	{1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
	int x[8];
	int i, j, c;
	char ret='?';
	for (i=0;i<9;++i) {
		x[i] = 2;
	}
	for (i=0;i<strlen(s);++i) {
		c=s[i]-49;
		//printf("%d - ", c);
		x[c]=i%2;
		//printf("%d\n", ((c/3)+1)%3);
		//b[(c%3+2)%3][c/3]=i%2;
	}
	//printf("\n\n\n");
	for (i=0;i<9;++i) {
		//printf("%3d", x[i]);
		//if (i%3==2) printf("\n");
	}

	for (i=0;i<8;++i) {
		//printf("%d: wi0: %d\n", i, w[i][0]);
		if (x[w[i][0]]<2 && x[w[i][0]] == x[w[i][1]] && x[w[i][0]] == x[w[i][2]]) {
			//printf("%d okk", i);
			ret = x[w[i][0]]?'X':'O';
		}
	}
	//printf("\n\n\n");

	
	printf("%c", ret);
}

#define z(p) x[w[i][p]]
void f3(char *s) {
	int w[8][3] = {0,1,2,3,4,5,6,7,8,0,3,6,
	1,4,7,2,5,8,0,4,8,2,4,6};
	int x[8]={2,2,2,2,2,2,2,2};
	int i, r='?';
	for (i=0;i<strlen(s);++i) {
		x[s[i]-49]=i%2;
	}
	for (i=0;i<8;++i) {
		if (z(0)<2 && z(0) == z(1) && z(0) == z(1)) {
			r=z(0)?'X':'O';
		}
	}
	printf("%c", r);
}

void f(char *s){int w[8][3]={0,1,2,3,4,5,6,7,8,0,3,6,1,4,7,2,5,8,0,4,8,2,4,6};int x[8]={2,2,2,2,2,2,2,2};int i,r='?';for(i=0;i<strlen(s);++i){x[s[i]-49]=i%2;}for(i=0;i<8;++i){if(z(0)<2&&z(0)==z(1)&&z(0)==z(2)){r=z(0)?'X':'O';}}printf("%c",r);}

main(int argc, char *argv[])
{
    char *s;
    s = "5237649";                    
    f(s);
}

