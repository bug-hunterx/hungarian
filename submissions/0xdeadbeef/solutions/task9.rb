def f(z)$x="";$m=0;$l=3;$c=0;$f=0;a=100
z.split(" ").each do|v|$m=[$m-1,0].max;case v
when"goomba","koopa","piranha"
if $m==0
$l-=1 if $f==0
$f=0
if $l==0
$x="GAME OVER"
break
end
end
when"Bowser","Princess";$x="WIN";break
when"1Up";$l+=1
when"Mushroom";$f=1;
when"Star";$m=3
when/^[0-9]+$/;$c+=v.to_i;while($c>=a)do $l+=1;$c-=a end
end
end
$x="???" if $x==""
print $x
end