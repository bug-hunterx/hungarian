<?php
function _f($s, $n, $w) {
	$o=$n*$w;
	while (($r=strlen($s))%($o)) $s.=" ";
	$a=array_chunk(str_split($s), $w);
	$r/=$o;

	for ($i=0;$i<$r;++$i) {
		for ($j=0;$j<$n;++$j) {
			echo implode("", $a[$i+$j*$r]).(($j<$n-1)?'|':'');
		}
		echo "\n";
	}
}

function f($s,$n,$w){$o=$n*$w;while(($r=strlen($s))%($o))$s.=" ";$a=array_chunk(str_split($s),$w);$r/=$o;for($i=0;$i<$r;++$i){for($j=0;$j<$n;++$j){echo implode("",$a[$i+$j*$r]).(($j<$n-1)?'|':'');}echo "\n";}}


f("Results, Relentlessly", 3, 4);
f("This is a longer text with, a, lot, of, unneeded, comma. And...    spaces.", 4, 5);
f("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 3, 1);