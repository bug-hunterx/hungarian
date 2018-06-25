a='';b='';f=(s)->
 a=' '+s+' '
 b=''
 while a!=b
  b=a;i=0
  while i<b.length
   c=B(i)
   if c=='/' and B(i+1)==' '
    x(i)
   else if c=='\\'and a.charAt(i-1)==' '
    x(i-1)
   else if c=='|'
    if B(i-1)=='/'and B(i+1)!='\\'
     a=C(i,'/')
    else if B(i+1)=='\\'and B(i-1)!='/'
     a=C(i,'\\')
   i++
 console.log a.trim()
x=(i)->a=C(i,'_');a=C(i+1,'_')
B=(i)->b.charAt(i)
C=(i, c)->a=a.substr(0,i)+c+a.substr(i+1)