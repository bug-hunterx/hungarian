f=(i)->
 b=[]
 winner=''
 ch=(p)->
  k=''
  w=[[1,2,3],[4,5,6],[7,8,9],[1,4,7],[2,5,8],[3,6,9],[1,5,9],[3,5,7]]
  k=p for v in w when b[v[0]]==b[v[1]] and b[v[1]]==b[v[2]] and b[v[0]]==p
  k
 i.split('').forEach((c,sn)->
  if not winner
   c=parseInt(c,10)
   b[c]=if sn%2==1 then 'X' else 'O'
   if sn+1>=5
    winner=ch(b[c]);
    if winner
     console.log(winner)
 )
 if not winner then console.log('?')
