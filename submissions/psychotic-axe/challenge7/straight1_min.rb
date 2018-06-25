def f(b,c)
f=b.split("\n")
m=Hash.new
t=f.size
if t>4
f.insert(-5,'')
t+=1
end
f.each_with_index{|floor,i|
w=Hash.new
floor.split("|").each{|j|
d=j.split(":")
o=d[1].to_i
w[o]=d[0].to_i}
m[t-1-i]=w}
g=1
h=c
p=[0]
l=Hash.new
s=0
while true
u=p.pop
e=m[u]
h+=l[u].to_i
l.delete(u)
a=e.clone.delete_if{|k,_|(k-u)*g<0}
if p.empty?&&e.size>0&&a.empty?&&s!=0
g*=-1
end
a=e.clone.delete_if{|k,_|(k-u)*g<0}
a.keys.each{|k|e.delete(k)}
a.each{|o,m|
if h>0
if m<h
a.delete(o)
h-=m
l[o]=l[o].to_i+m
else
h=0
end
(p<<o).sort!{|x,y|g*(y<=>x)}.uniq!
end}
e.merge!(a)
if h==0
r="polite after #{s} stops at #{u} floor"
break
elsif a.empty?&&h==c
r="lonely after #{s} stops at #{u} floor"
break
end
s+=1
end
puts r
end