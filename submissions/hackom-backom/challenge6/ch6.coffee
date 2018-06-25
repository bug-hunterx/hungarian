u=100
r=(p)->
 m=Math
 x=m.ceil
 k=500
 if p<2000
  (x p/u)*u
 else if p<5000
  k*x p / k
 else
  k*m.round((m.trunc p*1.1)/k)
f=(p)->
 q=console.log
 a=r p
 b=a-p
 if b==0||b>1500
  q 'PAID BY CARD'
 else if b%u!=0
  q 'KEEP THE CHANGE YOU FILTY ANIMAL'
 else
  q 'HERE IS '+a