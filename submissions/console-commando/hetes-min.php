function f($b, $c) {
	$a=explode("\n",$b);
	$z=count($a);
	$d=array();
	$p=$s=$z-($z>4?0:1);
	foreach($a as $v) {
		$u=[];
		$t = explode("|", $v);
		if (!empty($t[0]))
		foreach ($t as $w) {
			$u[] = explode(":", $w);
		}
		$d[$s] = $u;
		$s--;
		if ($s==4)$s--;
	}

	unset($d[4]);
	$l=1;
	$i=1;
	$g=-1;
	$e=0;
	$n=array_fill(0,$z+1,0);
	unset($n[4]);
	$f=1;
	$r='';
	$q=0;
	
	while ($l) {
		$j=0;
		if ($n[$e] > 0 || !$q) {
			$j=1;
			$g++;
			$f -= $n[$e];
			$n[$e] =0;
		}
		if ($e==0 && $i<1) {
			$i = -$i;
		} else if ($e == $p && $i==1) {
			$i = -$i;
		} else {
			if ($f==1 && $j && !empty($d[$e])) {
				$kz=array_keys($d[$e]);
				$h=$d[$e][$kz[0]][1];
				if ($h>$e) {
					$i=1;
				} else {
					$i=-1;
				}
			}
		}

		if (!empty($d[$e]) && $j){
			$t=0;
			foreach ($d[$e] as $k=>$v) {
				$m = $v[0];
				$h = $v[1];
				if (($h>$e && $i==1) || ($h<$e && $i<1)) {
					while($f<$c && $m>0) {
					  $n[$h]++;
					  $f++;
					  $m--;
					}
					$t=$m==0;
					if ($t) unset($d[$e][$k]);
					if (!$t) {
						$r="polite";break 2;
					}
				}
			}
		} else
		if ($f==1 && $q) {
			$l=0;
			$r='lonely';
			break;
		}
		$q += 1;
		$e+=$i;

		if ($e==4)$e+=$i;
	}
	echo "$r after $g stops at $e floor";
}