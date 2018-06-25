f=(i)->
 b=[]
 winner=''
 ch = (p) ->
  k = '';
  if b[1]==b[2] and b[1]==b[3] and b[1]==p then k=p;
  if b[4]==b[5] and b[4]==b[6] and b[4]==p then k=p;
  if b[7]==b[8] and b[7]==b[9] and b[7]==p then k=p;
  if b[1]==b[4] and b[1]==b[7] and b[1]==p then k=p;
  if b[2]==b[5] and b[2]==b[8] and b[2]==p then k=p;
  if b[3]==b[6] and b[3]==b[9] and b[3]==p then k=p;
  if b[1]==b[5] and b[1]==b[9] and b[1]==p then k=p;
  if b[3]==b[5] and b[3]==b[7] and b[3]==p then k=p;
  k
 i.split('').forEach((c,sn)->
  if not winner 
   c=parseInt(c,10)
   b[c]=if sn%2==1 then 'X' else 'O'
   if sn+1>=5
    winner = ch(b[c]);
    if winner
     console.log(winner)
 )
 if not winner then console.log('?')
