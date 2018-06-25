def f(s):
	from collections import Counter
	print("".join(sorted(sorted(s, key=lambda x: ord(x), reverse=False), key=Counter(s).get)))
	return;