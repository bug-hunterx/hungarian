sub f{
$x=3;
$_=$storyboard;
foreach(split){$c+=$_ if(/\d+$/);$x++if(/1Up/);if(/piranha|goomba|koopa/&&!$s){$m=0;$x--;}
if(/Mushroom/ && !$m){$m++;$x++;}
$s=3if(/Star/);
if($x<1){
print "GAME OVER\n";
exit
}
if(/Bowser|Princess/){
print "WIN\n";
exit
}
while($c>=100) {
$x++;
$c-=100;
}
$s--if $s;
}
print "???\n"
}