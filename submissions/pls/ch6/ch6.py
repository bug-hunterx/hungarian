import math
e=1000.0
def r(x,y):return int(math.ceil(x/y))*int(y)
def p(x,y):
	a,b=r(x,y),int(math.floor(x/y))*int(y)
	return(a,b)[abs(a-x)>abs(b-x)]
def f(a):
	t=r(a,100) if a<2*e else r(a,500) if a<5*e else p(a*1.1,500.)
	i=t-a
	print((("HERE IS "+str(t),"KEEP THE CHANGE YOU FILTY ANIMAL")[i%100!=0],"PAID BY CARD")[i==0 or i>1.5*e])