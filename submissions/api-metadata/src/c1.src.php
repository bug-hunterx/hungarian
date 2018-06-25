<?php

function f($i)
{
    global $c;
    $c = $d = count_chars($i, 1);
    uksort($d, function ($a, $b) {
        global $c;
        return $c[$a] == $c[$b] ? $a - $b : $c[$a] - $c[$b];
    });
    foreach ($d as $e => $f) {
        echo str_repeat(chr($e), $f);
    }
}