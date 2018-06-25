def f(i)
s=[0,0,3,0]
t='???'
i.split.each do |h|
case h[0]
when 'p','g','k'
if s[0]<1
(s[1]==0)?s[2]-=1:s[1]=0
end
when 'B','P'
t='WIN'
break
end
if h[0]=='M'
s[1]=1
elsif h[0]=='S'
s[0]=3
elsif h=='1Up'
s[2]+=1
elsif !!h[/\d+/]
s[3]+=Integer(h)
if s[3]>=100
s[2]+=s[3]/100
s[3]=s[3]%100
end
end
if s[2]<=0
t='GAME OVER'
break
end
s[0]-=1
end
puts t
end