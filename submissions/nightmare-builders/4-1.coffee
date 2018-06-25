c=(s,a)->
 for k in a
  if s.indexOf(k)<0 then return 1>2
 return 1<2
f=(s)->
 p=r=""
 x=["123","456","789","147","258","369","159","357"]
 for k,i in s
  if i%2==0 then p+=k else r+=k
  for u in x 
   if c(p,u) then console.log("O");return;
   if c(r,u) then console.log("X");return;
 console.log("?")