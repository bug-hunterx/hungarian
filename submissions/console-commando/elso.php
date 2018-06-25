
function f($a) {
global $t;
$t=$b=array_count_values(str_split($a));
@uksort($b, function ($d, $e) {
	global $t;
	//return($b[$d] > $b[$e])?1:($e < $d);
	return ($t[$d] > $t[$e]) || (($d >= $e) && ($t[$d] == $t[$e]));
});
foreach ($b as $key=>$value){
	echo str_repeat($key, $value);
}
}

//f("Hello, World!");
//f("Results, Relentlessly");