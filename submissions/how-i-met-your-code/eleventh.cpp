#include <iostream> 
#include <string>
#include <vector>

using namespace std;

void f(string p) {
 string r = "";
 int ind = p.find_first_of('\n'), rowc = p.length / ind;
 MyClass map[1000][1000];
 vector<pair<int, int> > turrets();
 for (int i = 0; i < rowc; ++i) {
  for (int j = 0; j < ind; ++j) {
   if (char c = p.at(i*ind + j) != ' ') {
    map[i][j].id = c;
   }
  }
 }
 cout << r;
}

class MyClass
{
public:
 MyClass() { id = 0; color = 0; }
 ~MyClass() {}

 int id;
 int color;
};