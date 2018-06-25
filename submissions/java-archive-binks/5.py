def step(s): 
 s=s.replace("/ ","__");
 s=s.replace("/| ","/( ");
 s=s.replace("/|_","/(_");
 s=s.replace("/|/","/(/");
 s=s.replace("/|)","//)");
 s=s.replace("/||","/(|");
 return s;
def fin(s):
 s=s.replace("(","/");
 s=s.replace(")","\\");
 return s;
def reverse(s):
 s=s[::-1];
 s=s.replace("/","a");
 s=s.replace("\\","/");
 s=s.replace("a","\\");
 s=s.replace("(","a");
 s=s.replace(")","(");
 s=s.replace("a",")");
 return s;
def bigStep(s):
 return fin(reverse(step(reverse(step(s)))));	
def f(s):	
 s=" "+s+" ";
 while not s==bigStep(s):
  s=bigStep(s);
 print(s);
