#	 	0
#	|	1
#	/	2
#	__	3
#	\	4
#	 	5
function f(){
esc=( '' '|' '/' '__' '\' ' ' )
#printf '%s\n' "${esc[@]}"

#S=( '12/22' '11/21' '15/335' '22/233' '21/22' '25/335' '1/33' '44/334' '14/44' '4/1' '51/4' '41/334' '31/334' '11/41' '1/33' ) #  '/' 
#printf '%s\n' "${S[@]}"


#echo "Normal input: '$1'"

act=$(sed -re "s/\|/1/g" <<< $1 | sed -re "s/\//2/g" | sed -re "s/__/3/g" | sed -re "s/\\\\/4/g" | sed -re "s/ /5/g" )
#echo "Normalized input: '$act'"


sk=() 
for((i=0; i<${#act}; i++)); do
	si=${act:i:1}
	if [[ $si -eq 2 && ${act:i+1:1} -eq 2 ]]; then $sk[$i]=1; $si=3; fi

	for((j=i+1; j<${#act}; j++)); do
		sj=${act:j:1}
		if [[ $sj -eq 2 && $sj -eq 2 ]]; then $sk[$j]=2; fi
#		if [[ 2 -eq $sj ]]; then ${act:i:1}; fi
	done
#	echo -en "$si"
done


#for task in "${S[@]}"; do
#	act=$(sed -re "s/$task/g" <<< $act)
#	#echo "After change: "$act
#done


#printf '%s\n' "${act[@]}"
echo -n "Final result: '"
echo "$act" | while read -n 1 c; do echo -n "${esc[$c]}"; done 
echo -n "'"
}
