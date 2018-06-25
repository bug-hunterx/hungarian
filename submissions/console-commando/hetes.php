<?php
function f2($b, $c) {
	$a=explode("\n",$b);
	$z=count($a);
	$d=array();
	foreach($a as $v) {
		$u=array();
		$t = explode("|", $v);
		if (!empty($t[0]))
		foreach ($t as $w) {
			$u[] = explode(":", $w);
		}
		$d[$z-count($d)-1] = $u;
	}
	//var_dump($d);
	$lifting=1;
	$irany=1; //1 fel, -1 le
	$stops=-1;
	$emelet=0;
	$cabin=array_fill(0,$z,0);
	$cnt=1;
	$res='';
	//var_dump($d);
	while ($lifting) {
		//echo "emelet: $emelet\n";
		//echo "kabin:\n";
		//var_dump($cabin);
		$stopped=0;
		//kell-e kiszallni?
		if ($cabin[$emelet] > 0) {
			if (!$stopped) {
				$stopped=1;
				$stops++;
			}
			$cnt -= $cabin[$emelet];
			$cabin[$emelet] =0;
		}
		//iranyvaltas?
		if ($emelet==0 && $irany<1) {
			$irany = -$irany;
		} else if ($emelet == $z-1 && $irany==1) {
			$irany = -$irany;
		} else {
			if ($cnt==1 && !empty($d[$emelet])) {
				$kz=array_keys($d[$emelet]);
				$hova=$d[$emelet][$kz[0]][1];
				if ($hova>$emelet) {
					$irany=1;
				} else {
					$irany=-1;
				}
			}
			//ha csak egyedul maradtam es van beszalló, akkor erkezesi sorrendben az első ember fogja eldonteni az iranyt
		}

		//kell-e beszallni?
		if (!empty($d[$emelet])){
			if (!$stopped) {
				$stopped=1;
				$stops++;
			}
			$t=0;
			foreach ($d[$emelet] as $k=>$v) {
				$mennyi = $v[0];
				$hova = $v[1];
				//echo "##$mennyi $hova\n\n";
				if (($hova>$emelet && $irany==1) || ($hova<$emelet && $irany<1)) {
					while($cnt<$c && $mennyi>0) {
					  $cabin[$hova]++;
					  $cnt++;
					  $mennyi--;
					}
					//echo " mennyi:$mennyi\n";
					$t=$mennyi==0;
					if ($t) unset($d[$emelet][$k]);
					if (!$t) {
						$res="polite";break 2;
					}
				}
			}
		}

		//egyedul maradtam-e
		if ($cnt==1) {
			$lifting=0;
			$res='lonely';
			break;
		}
		
		//emelkedes, sullyedes
		$emelet+=$irany;
		//var_dump($cabin);
		//var_dump($d);
		//break;
	}
	echo "$res after $stops stops at floor $emelet";
}

function f($b, $c) {
	//error_reporting(0);
	$a=explode("\n",$b);
	$z=count($a);
	$d=array();
	$top=$s=$z-($z>3?0:1);
	foreach($a as $v) {
		$u=array();
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
//var_dump($d);die();
	$lifting=1;
	$irany=1;
	$stops=-1;
	$emelet=0;
	$cabin=array_fill(0,$z+1,0);
	unset($cabin[4]);
	$cnt=1;
	$res='';
	$starter=0;
	
	while ($lifting) {
		/*
		echo "---------\n";
		echo "emelet: $emelet\n";
		echo "cnt: $cnt\n";
		echo "stops: $stops\n";
		echo "irany: $irany\n";
		var_dump($cabin);
		var_dump($d);
		//*/
		$stopped=0;
		if ($cabin[$emelet] > 0 || !$starter) {
			$stopped=1;
			$stops++;
			$cnt -= $cabin[$emelet];
			$cabin[$emelet] =0;
		}
		if ($emelet==0 && $irany<1) {
			$irany = -$irany;
		} else if ($emelet == $top && $irany==1) {
			$irany = -$irany;
		} else {
			if ($cnt==1 && $stopped && !empty($d[$emelet])) {
				$kz=array_keys($d[$emelet]);
				$hova=$d[$emelet][$kz[0]][1];
				if ($hova>$emelet) {
					$irany=1;
				} else {
					$irany=-1;
				}
			}
		}

		if (!empty($d[$emelet]) && $stopped){
			$t=0;
			foreach ($d[$emelet] as $k=>$v) {
				$mennyi = $v[0];
				$hova = $v[1];
				if (($hova>$emelet && $irany==1) || ($hova<$emelet && $irany<1)) {
					while($cnt<$c && $mennyi>0) {
					  $cabin[$hova]++;
					  $cnt++;
					  $mennyi--;
					}
					$t=$mennyi==0;
					if ($t) unset($d[$emelet][$k]);
					if (!$t) {
						$res="polite";break 2;
					}
				}
			}
		} else
		if ($cnt==1 && $starter) {
			$lifting=0;
			$res='lonely';
			break;
		}
		$starter += 1;
		$emelet+=$irany;

		if ($emelet==4)$emelet+=$irany;
	}
	echo "$res after $stops stops at floor $emelet";
}

//f("1:0|1:1\n3:2|5:0\n1:1|2:2",6);
//f("2:1|3:2\n1:0|1:1\n3:2|5:0\n1:1|2:2", 10);
//f("1:0|1:1\n1:3|5:5|2:0\n\n3:2|5:0\n1:1|2:2", 10);
//f("2:2|1:5\n3:8|1:0\n4:2|1:5|2:0\n1:1|2:0|4:2\n2:0|2:7\n1:0|1:8\n1:5|3:6|1:0\n1:1|1:3|2:5", 9);

f("1:0|1:1\n1:3|5:5|2:0\n\n3:2|5:0\n1:1|2:2", 10);
//f("2:2|1:5\n3:8|1:0\n4:2|1:5|2:0\n1:1|2:0|4:2\n2:0|2:7\n1:0|1:8\n1:5|3:6|1:0\n1:1|1:3|2:5", 9);