function f($o){$s=256;$g=[];for($i=0;$i<strlen($o);$i++){$q=substr($o,$i,1);if(!isset($g[ord($q)]))$g[ord($q)]=0;$g[ord($q)]++;}ksort($g);$r=[];for($i=0;$i<$s;$i++){$z=isset($g[$i])?$g[$i]:-1;if($z==-1)continue;if(!isset($r[$z]))$r[$z]=[];if(!isset($r[$z][$i]))$r[$z][$i]=0;$r[$z][$i]+=1;}ksort($r);foreach($r as $a=>$j){foreach($j as $d=>$l){echo str_repeat(chr($d),$a);}} }