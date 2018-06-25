static void f(string story){bool big=false;string result="GAME OVER";vector<string>storyArray;stringstream ss(story);string temp;while(ss>>temp){storyArray.push_back(temp);}
int life=3,coin=0,last=storyArray.size(),i=0,powerUp=0;for(int k=0;k<last;k++){if(""==storyArray.at(k))continue;char n=storyArray.at(k)[0];if(contains("gkp",n)&&powerUp<=0){if(big){big=!big;}else{life--;}}
if(life<=0){break;}
if(contains("BP",n)){result="WIN";break;}
if(contains("S",n)){powerUp=3;}
if(contains("M",n)){big=true;}
if("1Up"==storyArray.at(k)){life++;}
if(isNumeric(storyArray.at(k))){coin+=atoi(storyArray.at(k).c_str());int newLife=coin/100;life+=newLife;coin-=newLife*100;}
if(i==last){result="???";break;}
powerUp--;i++;}
cout<<result<<endl;}
static bool contains(string base,char item){bool returnValue=false;for(int i=0;i<base.length();i++){if(base[i]==item){returnValue=true;}}
return returnValue;}
static bool isNumeric(string s){bool error=false;for(int i=0;i<s.length();i++){if(!isdigit(s[i])){error=true;}}
return error;}