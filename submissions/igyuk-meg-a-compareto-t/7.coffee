f=(s,limit)->
 V=0
 Y=1
 E={}
 H=0
 L=s.split('\n').reverse().map((x)->x.split('|').map((y)=>y.split(':').map((x)->~~x)))
 L.splice 4,0,[]
 S=0
 W=0
 loop
  for k,v of E
   if k==V
     E[k]=0
  L[V] = L[V].filter (P)->
   if (P[1]-V)*Y>0
    E[P[1]]=~~E[P[1]]+P[0]
    return 0
   1
  H=0
  for k,v of E
   H+=v
  X=s[-1]
  for k,v of E
   continue unless v
   X=k if (k-V)*Y>0 and !(X*Y<k*Y)
  unless X or W
   Y=-Y
   W=1
  else
   W=0
   if H==0
    console.log "lonely after #{S} stops at #{V} floor"
    break
   if H>=limit
    console.log "polite after #{S} stops at #{V} floor"
    break 
   S++
   V=X
 
 