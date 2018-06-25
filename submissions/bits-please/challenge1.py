def f(s):
	word_list = s.lower().split(None)
	word_freq = {}
	for word in word_list:
		word_freq[word] = word_freq.get(word, 0) + 1
	list = sorted(word_freq.items(), key = lambda x:x[1], reverse = True)
	for word,freq in list:
		print ("%s" % word)