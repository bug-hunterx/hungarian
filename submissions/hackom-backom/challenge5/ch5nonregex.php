<?php

$input = '/| /|\\';

function f($i) {
	$parts = explode(' ',$i);
	
	foreach($parts as $part){
		for($i=0;$i<count($part);$i++){
			$l=count($part)-1;//last index
			$x=$part[$i];//current char
			
			
			// <-
			if($x=='\\'&&$i==0){
				$part[$i]='_';
			}
			
			// ->
			if($x=='/'&&$i==$l){
				$part[$i]='_';
			}

			
			// |\
			if($x=='|'&&$i<$l){
				if($part[$i+1]=='\\'){
					$part[$i]='_';
				}
			}
			
			// /|
			if(0<$i&&$x=='|'){
				if($part[$i-1]=='/'){
					$part[$i]='_';
				}
			}
			
			// _
			if($x=='_'){
				// do nothing
			}
			
			
		}
	}
	
	print_r($parts);
}

f($input);

?>