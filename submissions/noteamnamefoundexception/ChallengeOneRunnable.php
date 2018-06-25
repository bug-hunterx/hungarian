<?php function f($o){
		$s = 256;
		$freq = array(); 
    for( $i = 0; $i < strlen( $o ); $i++ ) {
        $char = substr( $o, $i, 1 );        
        if(!isset($freq[ord($char)])) $freq[ord($char)] = 0;
        $freq[ord($char)]++;
    }
    ksort($freq);
		$r = array(array());	
		for ($i = 0;$i <$s;$i++) {
			$fr = isset($freq[$i]) ? $freq[$i] : NULL;
      if ($fr == NULL) continue;
			if(!isset($r[$fr])) $r[$fr] = array();
      if(!isset($r[$fr][$i])) $r[$fr][$i] = 0;
      $r[$fr][$i] += 1;
		}
    ksort($r);
    foreach($r as $a => $j){
      foreach($j as $d => $l){
        echo str_repeat(chr($d),$a);
      }
    }  
}
f("Hello, World!");
f("Results, Relentlessly");
?>     