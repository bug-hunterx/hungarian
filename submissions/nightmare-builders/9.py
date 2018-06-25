import re
def f(s):
	b=0;l=3;i=0;m=False;t=s.split(" ")
	for u in t:
		if u.isdigit():
			b+=int(u)
			while b>100:b-=100;l+=1
		elif re.match("(g|k|p).*",u):
			if(i==0):
				if(m):m=False
				else:l-=1
		elif"Mushroom"==u:m=True
		elif"Star"==u:i=3
		elif"1Up"==u:l+=1
		elif re.match("(B|P).*",u):print("WIN");return;
		if(l==0):print("GAME OVER");return;
		i=i-1 if i>0 else i
	print("???");return;