def f(s,n,w):
	sp = [s[0+i:w+i] for i in range(0, len(s), w)]
	r=0
	while True:
		r+=1
		if r*n>len(sp): break
	sp += [""] * (r*n-len(sp))
	for row in range(r):
		print("|".join(i.ljust(w) for i in sp[row::n]))