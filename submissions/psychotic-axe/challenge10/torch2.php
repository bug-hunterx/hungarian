function f($n, $s) {
	if (strlen($s)!=0){
		$column = strpos($s, "\n");
		$array = str_split(str_replace("\n","",$s));
		$size = count($array);
		$row = $size / $column;
		$numberOfTorches = 0;
		for ($i = 0; $i< $column; $i++) {
			
			$stage = 0;
			
			$balance = true;
			$hasTrunk = false;
			$hasRoot = false;
			$hasFlame = false;
			$light = -1;
			for ($k = $i; $k < $size; $k+=$column) {
				$handled = false;
				$elem = $array[$k];
				if ($stage >0 && $elem != 'X' && $elem != '|' && $elem != '\\' && $elem != '/' && $elem != '.' && $elem != '$') {
					$stage=0;
					$balance = true;
					$hasTrunk = false;
					$hasRoot = false;
					$hasFlame = false;
					$light = -1;
					$handled = true;
				}
				if ($stage == 1 && $elem == 'X') {
					$hasRoot = true;
					$stage++;
					$handled = true;
				}
				if ($stage == 1 && $elem == '|') {
					$hasTrunk = true;
					$handled = true;
				}
				if (($stage == 1 || $stage == 5 || $stage == 6) && $elem == '\\') {
					if ($stage == 1) {
						$stage = 5;
						$balance = false;
						$hasTrunk = true;
					} else if($stage == 6) {
						$stage = 1;
						$balance = true;
						$hasTrunk = true;
					} else if($stage == 5) {
						$stage=0;
						$balance = true;
						$hasTrunk = false;
						$hasRoot = false;
						$hasFlame = false;
						$light = -1;
					}
					$handled = true;
				}
				if (($stage == 1 || $stage == 5 || $stage == 6) && $elem == '/') {
					if ($stage == 1) {
						$stage = 6;
						$balance = false;
						$hasTrunk = true;
					} else if($stage == 5) {
						$stage = 1;
						$balance = true;
						$hasTrunk = true;
					} else if($stage == 6) {
						$stage=0;
						$balance = true;
						$hasTrunk = false;
						$hasRoot = false;
						$hasFlame = false;
						$light = -1;
					}
					$handled = true;
				}
				if ($stage == 5 || $stage == 6) {
					$stage=0;
					$balance = true;
					$hasTrunk = false;
					$hasRoot = false;
					$hasFlame = false;
					$light = -1;
					$handled = true;
				}
				if ($stage == 0 && $elem == '.') {
					$light = $k;
					$hasFlame = true;
					$stage++;
					$handled = true;
				}
				if ($stage == 0 && $elem == '$') {
					$hasFlame = true;
					$stage++;
					$handled = true;
				}
				if (!$handled) {
					if ($elem == '.') {
						$light = $k;
						$hasFlame = true;
						$stage++;
						$handled = true;
						$balanced = true;
					} else if ($elem == '$') {
						$hasFlame = true;
						$stage++;
						$handled = true;
						$balanced = true;
					} else {
						$stage=0;
						$balance = true;
						$hasTrunk = false;
						$hasRoot = false;
						$hasFlame = false;
						$light = -1;
					}
				}
			}
			
			if ($hasRoot && $hasTrunk && $hasFlame && $balance && $handled) {
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
				print("\n");
			}
		}
	} else {
		print(":(");
	}
}