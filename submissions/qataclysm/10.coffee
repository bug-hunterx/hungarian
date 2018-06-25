f=(a,s)->
 b=s.split "\n"
 for r,k in b
  b[k]=r.split ""
 q=(m)->(t[i] for t in m) for i in [0...m[0].length]
 w=q b
 o=l=0
 z=[]
 for r,u in w
  j=r.join ""
  continue if !/[\.\$][\\\/|]+X$/.test j
  p=g=v=0
  for c in r
   p+=(c=='\\')
   p-=(c=='/')
   g+=(c=='.')
   v+=(c=="$")
   p=9 if p>1||p<-1
  continue if p!=0
  z.push u
  l+=v
  o+=g
 if l==0&&o==0
  console.log ":("
  return
 if l>a
  console.log a-l
  return
 if l+o<a
  console.log a-l-o
  return
 n=a-l
 for e in z
  r=w[e]
  for c,f in r
   if c=='.'
    if n>0
     r[f]="$"
     n--
 d=q w
 for r in d
  console.log r.join ""