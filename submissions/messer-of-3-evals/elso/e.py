def f(a):
	s=''.join(sorted(a))
	d={}
	for l in s:
		d[l] = d.get(l,0)+1
	for l in sorted(d, key=d.get, reverse=True):
		for n in range(0,d[l]):
			sys.stdout.write(l)
