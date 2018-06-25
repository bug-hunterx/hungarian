function f($input) 
{
    $input = change($input);
    echo $input;
}

function a($from, $to) {
    return array($from, $to);
}

$GLOBALS['c'] = array(
    a("/ ", "__"),
    a("/| ", "/__"),
    a("/ \\", "__\\"),
    a("/|/", "///"),
    a("\\|\\", "\\\\\\"),
    );


function changePiece($c) {
    foreach ($GLOBALS['c'] as $change) {
        if ($c == $change[0]) {
            return $change[1];
        }
    }
}

function canChange($c) {
    foreach ($GLOBALS['c'] as $change) {
           if ($c == $change[0]) {
               return true;
           }
    }
    return false;
}

function isLongerThanAnyFromString($c) {
    foreach ($GLOBALS['c'] as $change) {
        if (strlen($change[0]) >= strlen($c)) {
            return false;
        }
    }
    return true;
}

function changeOneFrame($input) 
{
    $replacementString = "";
    $charset = "";
    foreach (str_split($input) as $oneChar) {
        $charset += $oneChar;
        if (canChange($charset)) {
            $replacementString += changePiece($charset);
            $charset = "";            
        }
        else if (isLongerThanAnyFromString($charset)) {
            $replacementString += $charset;
            $charset = "";
        }
    }
    $replacementString += $charset;
    return $replacementString;
}

function change($input) 
{
    $originalInput = $input;
    
    $input = changeOneFrame($input);
    
    if ($originalInput == $input) {
        return $input;
    } else {
        return change($input);
    }
}
