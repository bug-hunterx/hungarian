f=(S) ->
 l=3;v=0;b=false;q=S.split(' ');s="???";c=0
 for w in q
  if w==""
   continue
  C=w[0]
  if C=='P'||C=='B'
   s ="WIN";break
  v--
  if C=='g'||C=='k'||C=='p'
   if v<0
    if !b
     l--
    b=false
  else if C>='a'&&C<='z'
   break
  if /^\d/.test(C)
   if w=="1Up"
    l++
   else
    c+=+w
  while c>=100
   l++;c-=100;
  if C=='M'
   b=true
  if C=='S'
   v=2
  if l==0
   s="GAME OVER";break;
 console.log(s)