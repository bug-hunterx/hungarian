f=(c)-> 
  n=Math
  m=n.ceil
  if c<2000 then a=m(c/100)*100
  else if c<5000 then a=m(c/500)*500
  else a=n.round(n.floor(c*1.1)/500)*500
  t=a-c
  if(t>0&&t<=1500)
    if((t%100)!=0) then r='KEEP THE CHANGE YOU FILTY ANIMAL'
    else r='HERE IS '+a 
  else r='PAID BY CARD'
  console.log(r)