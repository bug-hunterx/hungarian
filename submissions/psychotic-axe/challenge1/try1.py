def f(s):
 f=[0 for _ in range(100)]
 for c in s:f[ord(c)-ord(' ')]+= 1
 a=[]
 for i in range(len(f)):
  c=f[i]
  l=chr(ord(' ')+i)
  if c>0:a.append([c,ord(l),l])
 a.sort(key=lambda tup:(tup[0],tup[1]))
 r=""
 for i,v in enumerate(a):r+=(v[0]*v[2])
 print(r)
