p=print
def f(s):
	a=9*[0];b=9*[0]
	for i in range(len(s)):
		f=int(s[i])-1
		if i%2==0:
			a[f]=1
			if w(a):
				p("O")
				break
		else:
			b[f]=1
			if w(b):
				p("X")
				break
	else:
		p("?")
def w(n):
	a=all
	return a(n[:3])or a(n[3:6])or a(n[6:])or a(n[::3])or a(n[1::3])or a(n[2::3])or a(n[::4])or a(n[2:8:2])