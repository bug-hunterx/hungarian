def f(s,c,w):
 t=int((len(s)/w/c)+.9)
 for i in range(0,t*w,w):
  a=[]
  for j in range(0,c):
   x=j*t*w+i
   m=s[x:x+w]
   a.append(m.ljust(w))
  print('|'.join(a))