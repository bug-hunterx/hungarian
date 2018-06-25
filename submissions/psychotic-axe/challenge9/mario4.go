func f(s string){
p,b:="Princess","Bowser"
c,l,i:=0,3,-1
o, f:=false,false
if len(s)!=0{var t[] string=strings.Split(s, " ")
for _,e:=range t{if len(e)>0{if e==p||e==b{fmt.Println("WIN")
o=true
break}else{if u,h:=strconv.Atoi(e);h==nil&&u>0{c+=u
n:=c/100
if n>=1{l+=n
c-=n*100}}else{a:=len(s)
switch a{case
3:l+=1
case 4:i=2	
case 5:if i<0{l-=1
f=false}
case 6:if i<0{l-=1
f=false}
case 7:if i<0{
l-=1
f=false}
case 8:if !f{l+=1
f=true}}}}
i--
if l==0{fmt.Println("GAME OVER")
o=true
break}}}}
if!o{fmt.Println("???")}}