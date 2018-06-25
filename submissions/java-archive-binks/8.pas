procedure f(s:string;n:integer;w:integer);
var rs,i,p,c,r,j:integer;
begin 
rs:=((length(s)-1) div (n*w))+1;
i:=0;
while(i<(w+1)*n*rs)do 
begin 
if(i mod(w+1)=w)then 
begin 
if((((i+1)div(w+1)) mod n)=0)
then writeln()
else write('|');
end 
else 
begin 
p:=i mod(w+1);
c:=(i div(w+1))mod n;
r:=i div((w+1)*n);
j:=c*w*rs+w*r+p;
if(j<length(s))then 
write(s[j+1])
else 
write(' ');
end;
inc(i);
end 
end;
