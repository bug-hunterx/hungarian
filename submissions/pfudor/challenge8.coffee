f=(o,f,n)->
 r=[]
 l=f*n
 e=Math.ceil(o.length/l)
 t=''
 k=0
 while k<f
  j=0
  while j<e
   r[j]=r[j]or[]
   i=0
   while i<n
    r[j][i+k*n]=o[n*k*e+j*n+i]or' '
    i++
   j++
  k++
 j=0
 while j<e
  i=0
  while i<l
   t+=r[j][i]
   if 1==f and 1==n then (t+='\n') else if 1==n and i<1 then (t+='|') else if i>0 and i%(l-1)==0 then (t+='\n') else (i+1)%n==0 and (t+='|')
   i++
  j++
 console.log t
 return