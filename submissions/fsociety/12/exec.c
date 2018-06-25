
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void f(char*s,int c,int d)
{
	char*a=s;
	int w=0,h=1;
	while(*a)
	{
		if(*a=='\n'||!*a)
		{
			if(!w)w=a-s;
			h++;
		}
		a++;
	}

	int m[w][h],i,j;
	for(i=0;i<h;i++)
	{
		for(j=0;j<w;j++)
		{
			m[j][i]=*s++;
		}
		s++;
	}

	int x=0,y=0;
	char tc='>';char bc='>';
	int t=0,lb=0;
	int el;
	for(el=0;el<=100000;el++)
	{
		int n[256]={0};
		int b[256]={0};
		for(i=0;i<d;i++)
		{
			for(j=0;j<c;j++)
			{
				n[m[x+j][y+i]]++;
				b[m[x+j][y+i]]++;
			}
		}
	
		if(n['h'])
		{
			b['>']--;
			b['<']--;
		}
		if(n['H'])
		{
			b['>']++;
			b['<']++;
		}
		if(n['w'])
		{
			b['^']--;
			b['v']--;
		}
		if(n['"'])
		{
			b['^']++;
			b['v']++;
		}
		
		t=n[tc];
		if(n['<']>t&&b['<']>=0){tc='<';t=n[tc];}
		if(n['>']>t&&b['>']>=0){tc='>';t=n[tc];}
		if(n['^']>t&&b['^']>=0){tc='^';t=n[tc];}
		if(n['v']>t&&b['v']>=0){tc='v';t=n[tc];}
		

	
		if(tc=='<') x--;
		else if(tc=='>') x++;
		else if(tc=='^') y--;
		else if(tc=='v') y++;
		
		if(x<0||x+c>w||y<0||y+d>h) break;
	}
	
	if(el>=100000)
	{
		printf("%c", '8');
	}
	else
	{
		printf("%c", '9');
	}
}

main(int argc, char *argv[])
{
    //f("hh>>  \nHw>>  \nWvv   \nw v>  ", 6,4);
	f(">v>v>v\n^v^v^v\n^v^v^v\n^>^>^v\n^<<<<<\n",2,1);
f(">v>v>v\n^v^v^v\n^v^v^v\n^>^>^v\n^<<<<<\n",2,5);
f(">v>v>v\n^v^v^v\n^v^v^v\n^>^>^v\n^<<<<<\n",3,2)   ;
f(">v>v>v\n^v^v^v\n^v^v^v\n^>^>^v\n^<<<<<\n",6,5)  ;
f(">vhv>v\n^v>v^v\n^vHvwW\n^>^>>v\n^<<<<<",2,3);
f("hh>>\nHw>>\nWvv>\nwvv>",3,3);
}

