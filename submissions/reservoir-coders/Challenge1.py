def f(s):
  import operator
  d = { l : 0 for l in sorted(s)}
  for l in s:
    d[l] += 1
  sd = sorted(d.items(), key=operator.itemgetter(1,0))  
  for k in sd:
    for i in range(0,k[1]):
      sys.stdout.write(k[0])