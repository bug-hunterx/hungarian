import collections as c
def f(i):
	l=sorted(i)
	print(''.join(sorted(l,key=c.Counter(l).get)))