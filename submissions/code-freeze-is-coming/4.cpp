#include <iostream>
#include <map>
#include <stdio.h>
using namespace std;
static void f(string s) {
	int w[]={6,7,8,3,4,5,0,1,2,0,3,6,1,4,7,2,5,8,0,4,8,2,4,6};
	int z=3;
	map<int, string> b;
	for(int i = 0 ;i<=8;++i)
	{
		b[i] = "S";
	}
	for(int i = 0 ;i<s.length()-1;++i)
	{
		int val =  s[i] - '0';
		if (i%2==1) {
			b[val-1] = "X"; }
		else {
			b[val-1] = "O"; }
		for(int i = 0 ;i<8;++i)
		{
			if (b[w[i*z]] == b[w[i*z+1]] && b[w[i*z+1]] == b[w[i*z+2]] && b[w[i*z]] != "S")
			{
				cout << b[w[i*z]];
				return;
			}
		}
	}
	cout << "?";
}