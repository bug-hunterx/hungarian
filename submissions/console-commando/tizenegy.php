<?php
	function rajz($p) {
		foreach ($p as $row) {
			foreach ($row as $c)
				echo $c;
			echo PHP_EOL;
		}
	}//*/


function f($s) {
	error_reporting(0);
	$p=array();
	$beams=array();
	$a=explode("\n", $s);
	$turrets=array();
	$targets=array();
	$mirrors=array();
	$cubes=array();
	$portals=array();
	$dirs = ['<' => [0, -1], '>' => [0, 1], 'v' => [1, 0], '^' => [-1, 0]];
	$tukor[">/"]=[-1, 0, '^'];
	$tukor[">\\"]=[1, 0, 'v'];
	$tukor["</"]=[1, 0, 'v'];
	$tukor["<\\"]=[-1, 0, '^'];
	$tukor["v/"]=[0, -1, '<'];
	$tukor["v\\"]=[0, 1, '>'];
	$tukor["^/"]=[0, 1, '>'];
	$tukor["^\\"]=[0, -1, '<'];
	foreach ($a as $rownum => $row) {
		foreach (str_split($row) as $k => $e) {
			$p[$rownum][$k] = $e;
			if (in_array($e, ['<', '>', 'v', '^'])) {
				$turrets[] = [$rownum, $k, $e, $dirs[$e]];
			}
			if (is_numeric($e)) {
				$portals[$e][] = [$rownum, $k];
			}
			if ($e=="@") {
				$targets[$rownum."_".$k] = 0;
			}
			if ($e=="#") {
				$cubes[] = [$rownum, $k, $e];
			}
		}
	}
	$h=count($p)-1;
	$w=count($p[0])-1;
	//var_dump($h, $w);
	$lott_target=0;
	$utkozes=0;
	foreach ($turrets as $ti=>$t) {
		$x=$t[0];
		$y=$t[1];
		$e=$t[2];
		$d=$t[3];
		$megyen=1;
		while ($megyen) {
			$x+=$d[0];
			$y+=$d[1];
			//echo "X:$x Y:$y\n";
			if ($x<0 || $y<0 || $x>$h || $y>$w) {
				$megyen=0;
				break;
			}
			$pp=$p[$x][$y];
			if ($pp == " ") {
				$p[$x][$y] = chr(ord('a')+$ti);
				continue;
			}
			if ($pp == "@") {
				if ($targets[$x."_".$y]==0){
					$targets[$x."_".$y]=1;
					$lott_target++;
					$megyen=0;
				}
				break;
			}
			if ($pp == "#") {
				$megyen=0;
				break;
			}
			if ($pp>='a' && $pp <='z'){
				if ((ord('a')+$ti)!=ord($pp)){
					$utkozes=1;
					break 2;
				} else continue;
			}
			if (in_array($pp, ['<', '>', 'v', '^'])) {
				$megyen=0;
				break;
			}

			if (is_numeric($pp)) {
				$egyik=$portals[$pp][0];
				$masik=$portals[$pp][1];
				if ($egyik[0]==$x && $egyik[1]==$y){
					$x=$masik[0];
					$y=$masik[1];
				}else
				if ($masik[0]==$x && $masik[1]==$y){
					$x=$egyik[0];
					$y=$egyik[1];
				}
				continue;
			}
			if ($pp=="/" || $pp=="\\") {
				$conv=$tukor[$e.$pp];
				$d[0]=$conv[0];
				$d[1]=$conv[1];
				$e=$conv[2];
				//echo $e;
			}
		}
	}
	//echo "\n\n*************\n".$s."\n*************\n".PHP_EOL;rajz($p);
	//echo "fdfsd:".count($targets);
//var_dump($lott_target);
//var_dump($targets);
	if ($utkozes) echo ":/";
	else if ( ($lott_target==count($targets)) && $lott_target>0) echo ":D";
	else echo ":(";

}
$a=<<<EOF
      @   
   / \\  /
 >   /    
   \\     
EOF;
f($a);


$a=<<<EOF
 2      
 @  /  \\
 > 12 1/
        
EOF;
f($a);

die();
$a=<<<EOF
    v   @  \\     
/   \\ 1  / / 
\\ 1      /    
            
EOF;

f($a);

$a=<<<EOF
      v  
         
  9 # 9 @
  \\   /   
  #               
EOF;
f($a);

f("  @      v  \n" .
 "> / <  @ \\ @\n" .
 "  @      ^  ");

f("v   \\    \n" .
 "          \n" .
 "\\  \\     \n" .
 "         ");
f(" >   \\     \n" .
 " >   \\    @ \n" .
 "     \\     \n" .
 "            ");

f("           \n" .
 " >   \\    \n" .
 "     \\    \n" .
 "            ");
f("         \n" .
 ">   >   @\n" .
 "  #      ");

f(" vvvv\n".
 " \\\\\\\\\\\n".
 " /////\n".
 " 1234\n".
 " 4321\n".
 "///// \n".
 "\\\\\\\\\\ \n".
 " @@@@");



f("     v \n".
 "> 9#9 @");
f("> \\  @\n" .
 "> \\  @\n" .
 "> \\  @");

f("      v  \n" .
 "> 9 # 9 @\n" .
 "  #      ");



 //*/