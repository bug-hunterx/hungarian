<?php
function _f($s) {
	$s=trim(str_replace("  ", " ", $s))." x";
	$z = 0;
	$l = 3;
	$c = 0;
	$r = -1;
	foreach (explode(" ", $s) as $p) {
		$r--;
		if ($c>=100) {$l++;$c-=100;};
		if ($l == 0) {echo "GAME OVER";return;}
		else if ($p[0] == "P" || $p[0] == "B") { echo "WIN";return;}
		else if ($p[0] == "S") {$r=2;}
		else if (($p[0] == "p" || $p[0] == "k" || $p[0] == "g")&&$r<0) {$z?$z=0:$l--;}
		else if (@$p[1] == "U") {$l++;}
		else if ($p[0] == "M") {$z=1;}
		else {$c+=$p;}
	}
	echo "???";
}

function f($s){$s=trim(str_replace("  "," ",$s))." x";$z=$c=0;$l=3;$r=-1;foreach(explode(" ",$s)as$p){$r--;if($c>=100){$l++;$c-=100;};if(!$l){echo"GAME OVER";return;}elseif($p[0]=="P"|$p[0]=="B"){echo"WIN";return;}elseif($p[0]=="S")$r=2;elseif(($p[0]=="p"|$p[0]=="k"|$p[0]=="g")&&$r<0)$z?$z=0:$l--;elseif(@$p[1]=="U")$l++;elseif($p[0]=="M")$z=1;else$c+=$p;}echo"???";}

f("piranha Princess piranha"); # => `WIN`
f("1Up koopa goomba piranha Bowser"); # => `WIN`
f("Star Mushroom  piranha goomba piranha goomba Princess"); #` => `WIN`
f(" piranha piranha piranha piranha"); #` => `GAME OVER`
f("piranha piranha Star goomba goomba Princess"); #` => `WIN`
f("10 40 koopa goomba 20 30 piranha piranha"); #` => `GAME OVER`
f("10 40 20"); #` => `???`