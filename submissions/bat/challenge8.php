function f($i,$n,$w){
$s=$w*$n-strlen($i)%($w*$n);
$r=$i.str_repeat(" ",$s<$w*$n?$s:0);
$m=[];
$h=round(strlen($r)/$n/$w);
$h=$h<1?1:$h;
$c=str_split($r,$w);
for($x=0;$x<$h;$x++)$m[$x]=[];
$j=0;$k=0;
for($x=0;$x<count($c);$x++){
$m[$j][$k]=$c[$x];
if($j+1<$h)$j++;
else{
$k++;
$j=0;
}
}
for($x=0;$x<$h;$x++)$m[$x]=join("|",$m[$x]);
fwrite(STDOUT,join("\n",$m));
}

