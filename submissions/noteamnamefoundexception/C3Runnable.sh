#!/bin/bash
declare -A a=( 
["a"]="I ain't afraid of no ghost\n"
[" "]="\n"
["b"]="Ghostbusters\n"
["c"]="If there's something "
["d"]="strange\n"
["e"]="In "
["f"]="you "
["F"]="You "
["g"]="neighborhood"
["W"]="Who "
["h"]="gonna call\n"
["i"]="weird"
["j"]="And it don't look good"
["k"]="If you're seeing things\nRunning through your head"
["m"]="can "
["n"]="An invisible man\nSleeping in your bed"
["o"]="If you're all alone\nPick up the phone"
["p"]="And call\n"
["q"]="I here it likes the girls"
["r"]="Yeah "
["s"]="yeah yeah yeah\n"
["t"]="ya "
["u"]="If you've had a dose of a\nFreaky ghost baby"
["v"]="Lemme tell ya something\nBustin' makes me feel good"
["w"]="Don't get caught alone no no"
["x"]="When it comes through your door\nUnless you just want some more"
["y"]="better "
["z"]="I think "
["0"]="I can't hear you"
["1"]="Louder"
["C"]="call\n"
)
list="bcdefg Wfhbci j Wfhb aa k WmfCbn Wfhb aa Wfhbo pb aq ars Wthb u FyCb v  aa w  b x zfyCb Wthb Wthb zfyCb Wthb 0 Wthb 1 b Wthb WmtCb Wthb "
for (( i=0; i<${#list}; i++ )); do
  c="${list:$i:1}"
  s=${a["$c"]}
  echo -ne "$s"
done


