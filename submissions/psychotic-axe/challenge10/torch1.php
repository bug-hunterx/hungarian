function f($n, $s) {
	$array = str_split(str_replace("\n","",$s));
	
	$column = strpos($s, "\n");
	$size = count($array);
	$row = $size / $column;
	$numberOfTorches = 0;
	for ($i = 0; $i< $column; $i++) {
		
		$stage = 0;
		
		$balance = 0;
		$hasTrunk = false;
		$hasRoot = false;
		$hasFlame = false;
		$light = -1;
		for ($k = $i; $k < $size; $k+=$column) {
			$elem = $array[$k];
			if ($stage >0 && $elem != 'X' && $elem != '|' && $elem != '\\' && $elem != '/' && $elem != '.' && $elem != '$') {
				$stage=0;
				$balance = 0;
				$hasTrunk = false;
				$hasRoot = false;
				$hasFlame = false;
				$light = -1;
			}
			if ($stage == 1 && $elem == 'X') {
				$hasRoot = true;
				$stage++;
			}
			if ($stage == 1 && $elem == '|') {
				$hasTrunk = true;
			}
			if ($stage == 1 && $elem == '\\') {
				$balance--;
				$hasTrunk = true;
			}
			if ($stage == 1 && $elem == '/') {
				$balance++;
				$hasTrunk = true;
			}
			if ($stage == 0 && $elem == '.') {
				$light = $k;
				$hasFlame = true;
				$stage++;
			}
			if ($stage == 0 && $elem == '$') {
				$hasFlame = true;
				$stage++;
			}
		}
		
		if ($hasRoot && $hasTrunk && $hasFlame && ($balance == 0)) {
			if ($light != -1) {
				$array[$light] = '$';
			}
			$numberOfTorches++;
		}
	}
	
	if ($numberOfTorches == 0) {
		print(":(");
	} else if ($n != $numberOfTorches) {
		print($n - $numberOfTorches);
	} else {
		for($i = 0; $i < $row; $i++) {
			for($j = 0; $j < $column; $j++) {
				print($array[$i*$column+$j]);
			}
			print("<br/>");
		}
	}
}