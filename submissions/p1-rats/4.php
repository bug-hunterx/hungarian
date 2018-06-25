function f($s){
$x=$y="";
$w=array("123","456","789","147","258","369","159","357");
$a=$b=99;
for($i=0;$i<strlen($s);$i++){
if($i%2==0){$x=$x.$s[$i];}else{$y=$y.$s[$i];}}
foreach($w as $v)
{
$m=max(strpos($s,$v[0]),strpos($s,$v[1]),strpos($s,$v[2]));
if(strspn($v,$x) == 3)
{$a=$m;}
if(strspn($v,$y) == 3)
{$b=$m;}}
if($a==99&&$b==99){print"?"; exit;}
if($a>$b){print"X";}else{print"O";}
}