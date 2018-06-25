def f(s)
s=' '+s+' '
a=[0]
for i in 0..s.length-1
if s[i]==' '
a.push(i)
end
end
a.push(s.length)
for i in 0..a.length-2
s=s(s,a[i],a[i+1])
end
puts s
end
def s(s,m,n)
i=m
j=1
l=-9
k=99
c=0
d=0
while(i>m-1&&i<n)
case s[i]
when'\\'
case s[i-1]
when' '
s[i]='_'
s[i-1]='_'
if j==1
i=n
j=-1
else
i=m
j=1
end
when'|'
if(s[i-2]!='/'||(l==i-3&&c!=d))
s[i-1]='\\'
d=d+1
if j==1
i=n
j=-1
else
i=m
j=1
end
end
end
when'/'
case s[i+1]
when' '
s[i]='_'
s[i+1]='_'
if j==1
i=n
j=-1
else
i=m
j=1
end
when'|'
if s[i+2]!='\\'
s[i+1]='/'
l=i
c=c+1
if j==1
i=n
j=-1
else
i=m
j=1
end
end
end
end
i=i+j
end
return s
end