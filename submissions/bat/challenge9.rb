def f(s)
$x=s.split(" ")
$m=Hash["c",0,"l",3,"b",0,"i",0]
$r='???'
def e()
if $m["i"]==0;if $m["b"] > 0;$m["b"]=0;else $m["l"]-=1;end
end
end
def c(a)
$m["c"]+=a.to_i
$h=($m["c"]/100).floor
if $h>0;$m["l"]+=$h;$m["c"]-=$h*100
end
end
for i in 0..$x.length
case $x[i]
when '1Up';$m["l"]+=1
when 'Star';$m["i"]=3
when 'Mushroom';$m["b"]=1
when "goomba","koopa","piranha";e()
when "Bowser","Princess";$r="WIN"
else c($x[i])
end
if $m["l"]<1 && $r!='WIN'
$r='GAME OVER';break;end
if $m["i"]>0;$m["i"]-=1;end;end
puts $r
end