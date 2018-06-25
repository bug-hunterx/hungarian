def f(b):
	a={};d={};s=sorted
	for c in b:a[c]=(a.get(c)or 0)+1
	for k,v in a.items():d[v]=(d.get(v)or [])+[k]
	print("".join(["".join(s(k*d[k]))for k in s(d.keys())]))