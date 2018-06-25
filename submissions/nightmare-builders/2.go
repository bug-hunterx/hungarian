func q(s string)string{return"["+regexp.QuoteMeta(s)+"]"}
func f(s string){
A:="`1234567890-=~!@#$%^&*()_+"
B:="qwertyuiop[]QWERTYUIOP{}"
C:="asdfghjkl;'\\ASDFGHJKL:\"|"
D:="zxcvbnm,./ZXCVBNM<>?"
m:=[]string{q(A),q(B),q(C),q(D)}
k2:=[]string{A,B,C,D}
r:=s
r1:=s
rp:=0
for i:=0;i<len(m);i++{p:=s
for j:=0;j<len(m);j++{if i!=j{re,_:=regexp.Compile(m[j])
p=re.ReplaceAllString(p,"")}}
if len(p)>0{pm:=""
for k:=0;k<len(p);k++{if!(strings.IndexByte(pm,p[k])>=0){pm+=string(p[k])}}
ap:=0
for l:=0;l<len(m);l++{re,_:=regexp.Match(pm[0:1],[]byte(m[l]))
if re{ap=i}}
if len(r)>len(p)||len(r1)>len(pm)||(len(r)==len(pm)&&ap<rp){r=p
r1=pm
rp=ap}}}
for i:=0;i<len(k2[rp]);i++{if strings.IndexByte(r,k2[rp][i])>-1{
fmt.Print(string(k2[rp][i]))}}}