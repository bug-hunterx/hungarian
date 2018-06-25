<?php

function f($i){
	$t=($i>=5e3)?round(floor($i*1.1)/500)*500-$i:ceil($i/500)*500-$i;
	if($i<2e3)$t=ceil($i/100)*100-$i;
	echo (!$t||$t>1500)?"PAID BY CARD\n":(
	($t%100>0)?"KEEP THE CHANGE YOU FILTY ANIMAL\n":
	"HERE IS ".($i+$t)."\n"
	);
}

echo '<pre>';

echo 'I PAID:'; f(100);
echo 'HERE IS 16500'; f(15000);
echo 'KEEP:'; f(1199);
echo 'KEEP:'; f(1999);
echo 'KEEP:'; f(6185);
echo 'KEEP:' ;f(6288);
echo 'HERE IS 3000:'; f(2800);
echo 'I PAID:'; f(2500);
echo "-\n";
echo '99? '; f(99);