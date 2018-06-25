#include <vector>
#include <algorithm>
#define X std::cout <<
#define V std::vector<int>
#define B (r.begin(), r.end())
void f(std::string s){V r=V(8);int p=1;for(int i=0;i<s.length();i++){int t=s[i]-'1';int e=t+1;r[t/3]+=p;r[t%3+3]+=p;if(e%4==1)r[6]+=p;if(e==3||e==5||e==7)r[7]+=p;p=-p;};if(*std::max_element B==3)X"O";else if(*std::min_element B==-3)X"X";else X"?";}