<?php

$i='/| /| /| /| /|';

function f($s){
	$p=array(
		'/(\/\|[])/'//		/|	::	/_
		,'/\//'//		/	::	_
		//,''
	);
	$c=array(
		'\/_'
		,'_'
	);
	$o=preg_replace($p,$c,$s);
	echo $o;
}

f($i);

?>