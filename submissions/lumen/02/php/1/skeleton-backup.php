function f($text) {
	global $sortOrder;
	$keyBoard = [0=>"1234567890-=!@#$%&*()_+",1=>"qwertyuiop[]\QWERTYUIOP{}|",2=>"asdfghjkl;ASDFGHJKL:",3=>"zxcvbnm,./ZXCVBNM<>?"];
	$charsByRows = [];
	
	foreach(str_split($text) as $char) {
		foreach ($keyBoard as $key => $value) {
			if (strpos($value,$char) !== false) {
				if (array_key_exists($key, $charsByRows) )
					$charsByRows[$key] .= $char;
				else
					$charsByRows[$key] = $char;
			}
		}
	}
		
	$shortest = [];
	foreach ($charsByRows as $key => $value) {
		if (count($shortest)==0 || firstLen($shortest)>l($value)) {
			$shortest = [$key=>$value];
		} elseif (firstLen($shortest)==l($value)) {
			$shortest[$key] = $value;
		}
	}
		
	$shortestUnique = [];
	foreach($shortest as $key => $value) {
		if(count($shortestUnique)==0||firstLen($shortestUnique)>l(u($value))) {
			$shortestUnique = [$key=>u($value)];
		} elseif(firstLen($shortestUnique)==l(u($value))) {
			$shortestUnique[$key] = u($value);
		}
	}
	
	$result = $shortestUnique[min(array_keys($shortestUnique))];
	
	
	foreach ($keyBoard as $key => $value) {
			if (strpos($value,$result[0]) !== false) {
				$sortOrder = $value;
			}
	}
	$parts = str_split($result);
	usort($parts, 'cmp');
	
	echo implode('', $parts);
}

function u($a){$r="";foreach(str_split($a)as$c)if(strpos($r,$c)===false)$r.=$c;return $r;}

function firstLen($a) {
	return l(array_values($a)[0]);
}

function l($s) {
	return strlen($s);
}


function cmp($a, $b) {
	$o=$GLOBALS['sortOrder'];
    if (strPos($o, $a) == strPos($o, $b)) {
        return 0;
    }
    return (strPos($o, $a) < strPos($o,$b)) ? -1 : 1;
}